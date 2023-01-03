package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Customer;
import gr.codelearn.spring.showcase.app.domain.Order;
import gr.codelearn.spring.showcase.app.domain.OrderItem;
import gr.codelearn.spring.showcase.app.domain.Product;
import gr.codelearn.spring.showcase.app.domain.enumeration.PaymentMethod;
import gr.codelearn.spring.showcase.app.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

	private final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	private final OrderRepository orderRepository;

	@Override
	public Order create(final Order order) {
		logger.trace("Creating {}.", order);
		return orderRepository.save(order);
	}

	@Override
	public List<Order> createAll(Order... entities) {
		return createAll(List.of(entities));
	}

	@Override
	public List<Order> createAll(final List<Order> orders) {
		final List<Order> updatedEntities = new ArrayList<>();
		for (final Order order : orders) {
			updatedEntities.add(create(order));
		}
		return updatedEntities;
	}

	@Override
	public void update(final Order order) {
		logger.trace("Updating {}.", order);
		orderRepository.save(order);
	}

	@Override
	public void delete(final Order order) {
		logger.trace("Deleting {}.", order);
		orderRepository.delete(order);
	}

	@Override
	public void deleteById(final Long id) {
		final Order entityFound = orderRepository.getReferenceById(id);
		logger.trace("Deleting {}.", entityFound);
		orderRepository.deleteById(id);
	}

	@Override
	public boolean exists(final Order order) {
		logger.trace("Checking whether {} exists.", order);
		return orderRepository.existsById(order.getId());
	}

	@Override
	public List<Order> findAll() {
		logger.trace("Retrieving all data.");
		return orderRepository.findAll();
	}

	@Override
	public Order find(Long id) {
		return null;
	}

	public Order get(Long id) {
		return orderRepository.getReferenceById(id);
	}


	@Override
	public Order initiateOrder(Customer customer) {
		return Order.builder().customer(customer).build();
	}

	@Override
	public void addItem(Order order, Product product, int quantity) {
		if (checkNullability(order, product)) {
			return;
		}

		boolean increasedQuantity = false;

		// If product is already contained in the order, don't add it again, just increase the quantity accordingly
		for (OrderItem oi : order.getOrderItems()) {
			if (oi.getProduct().getSerial().equals(product.getSerial())) {
				oi.setQuantity(oi.getQuantity() + quantity);
				increasedQuantity = true;
				break;
			}
		}

		if (!increasedQuantity) {
			order.getOrderItems().add(newOrderItem(order, product, quantity));
		}

		logger.debug("Product[{}] added to Order[{}]", product, order);
	}

	private boolean checkNullability(Order order, Product product) {
		if (order == null) {
			logger.warn("Order is null.");
			return true;
		}
		if (product == null) {
			logger.warn("Product is null.");
			return true;
		}
		return false;
	}

	@Override
	public void updateItem(Order order, Product product, int quantity) {
		if (checkNullability(order, product)) {
			return;
		}

		order.getOrderItems().removeIf(oi -> oi.getProduct().getSerial().equals(product.getSerial()));
		order.getOrderItems().add(newOrderItem(order, product, quantity));

		logger.debug("Product[{}] updated in Order[{}]", product, order);
	}

	@Override
	public void removeItem(Order order, Product product) {
		if (checkNullability(order, product)) {
			return;
		}

		order.getOrderItems().removeIf(oi -> oi.getProduct().getSerial().equals(product.getSerial()));
		logger.debug("Product[{}] removed from Order[{}]", product, order);
	}

	@Override
	public Order checkout(Order order, PaymentMethod paymentMethod) {
		if (!validate(order)) {
			logger.warn("Order should have customer, order items, and payment type defined before being able to " +
								"checkout the order.");
			return null;
		}

		// Set all order fields with proper values
		order.setPaymentMethod(paymentMethod);
		order.setSubmitDate(new Date());
		order.setCost(giveDiscounts(order));

		return create(order);
	}

	private boolean validate(Order order) {
		return order != null && !order.getOrderItems().isEmpty() && order.getCustomer() != null;
	}

	private OrderItem newOrderItem(Order order, Product product, int quantity) {
		return OrderItem.builder().order(order).product(product).quantity(quantity).price(product.getPrice()).build();
	}

	private BigDecimal giveDiscounts(Order order) {
		float totalDiscount =
				order.getCustomer().getCustomerCategory().getDiscount() + order.getPaymentMethod().getDiscount();

		// Calculate original order cost
		//@formatter:off
		BigDecimal originalCost = order.getOrderItems().stream()
									   .map(oi -> oi.getPrice().multiply(BigDecimal.valueOf(oi.getQuantity())))
									   .reduce(BigDecimal.ZERO, BigDecimal::add);
		//@formatter:on

		// Apply discount
		BigDecimal finalCost = originalCost.multiply(BigDecimal.valueOf(1f - totalDiscount));

		logger.debug("Order[{}], originalCost: {}, totalDiscount: {}, finalCost: {}.", order.getId(), originalCost,
					 totalDiscount, finalCost);

		return finalCost;
	}
}

package gr.codelearn.spring.showcase.app.configuration;

import gr.codelearn.spring.showcase.app.domain.Customer;
import gr.codelearn.spring.showcase.app.domain.Order;
import gr.codelearn.spring.showcase.app.domain.enumeration.CustomerCategory;
import gr.codelearn.spring.showcase.app.repository.CustomerRepository;
import gr.codelearn.spring.showcase.app.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
@EnableAsync
public class AsyncTaskConfig {

	private static final Logger LOG = LoggerFactory.getLogger(AsyncTaskConfig.class);

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Async
	@Transactional
	public void doBatchProcessing() throws InterruptedException {
		Thread.sleep(5000);

		Map<CustomerCategory, List<Customer>> customersByCategory = customerRepository.findAll()
				.stream()
				.collect(Collectors.groupingBy(Customer::getCustomerCategory));

		customersByCategory.forEach(
				(key, value) -> LOG.info("There are {} customers at {} category with discount of {}", key.name(), value.size(), key.getDiscount()));

		Thread.sleep(2000);

		List<Order> orders = orderRepository.findAll().stream().map(this::calculateDiscounts).toList();
		LOG.info("Total order value after discounts are applied: {}", orders.stream().map(Order::getCost).reduce(BigDecimal.ZERO, BigDecimal::add));

		Thread.sleep(1000);
		orderRepository.saveAll(orders);
		LOG.info("Batch Processing Finished");
	}

	private Order calculateDiscounts(Order order) {
		float discount = 1.0f - order.getCustomer().getCustomerCategory().getDiscount();
		BigDecimal finalCost = order.getCost().multiply(BigDecimal.valueOf(discount));
		order.setCost(finalCost.round(MathContext.DECIMAL32));
		return order;
	}
}

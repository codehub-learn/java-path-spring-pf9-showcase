package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Customer;
import gr.codelearn.spring.showcase.app.domain.Order;
import gr.codelearn.spring.showcase.app.domain.Product;
import gr.codelearn.spring.showcase.app.domain.enumeration.PaymentMethod;

import java.util.List;

public interface OrderService {

	Order create(Order order);

	List<Order> createAll(Order... orders);

	List<Order> createAll(List<Order> orders);

	void update(Order order);

	void delete(Order order);

	void deleteById(Long id);

	boolean exists(Order order);

	List<Order> findAll();

	Order find(Long id);

	Order get(Long id);
	
	Order initiateOrder(Customer customer);

	void addItem(Order order, Product product, int quantity);

	void updateItem(Order order, Product product, int quantity);

	void removeItem(Order order, Product product);

	Order checkout(Order order, PaymentMethod paymentMethod);

}

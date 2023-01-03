package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Customer;
import gr.codelearn.spring.showcase.app.domain.Order;
import gr.codelearn.spring.showcase.app.domain.Product;
import gr.codelearn.spring.showcase.app.domain.enumeration.PaymentMethod;

public interface OrderService extends BaseService<Order, Long> {

	Order initiateOrder(Customer customer);

	void addItem(Order order, Product product, int quantity);

	void updateItem(Order order, Product product, int quantity);

	void removeItem(Order order, Product product);

	Order checkout(Order order, PaymentMethod paymentMethod);

}

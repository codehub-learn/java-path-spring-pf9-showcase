package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.Order;

import java.util.List;

public interface OrderRepository  {

	Order create(Order order);

	List<Order> createAll(List<Order> orders);

	void update(Order order);

	void delete(Order order);

	void deleteById(Long id);

	boolean exists(Order order);

	Order get(Long id);

	List<Order> findAll();
}

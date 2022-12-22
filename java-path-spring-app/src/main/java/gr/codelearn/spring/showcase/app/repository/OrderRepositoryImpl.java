package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

	private final List<Order> storage = new LinkedList<>();

	@Override
	public Order create(final Order order) {
		storage.add(order);
		return null;
	}

	@Override
	public List<Order> createAll(final List<Order> orders) {
		storage.addAll(orders);
		return null;
	}

	@Override
	public void update(final Order order) {

	}

	@Override
	public void delete(final Order order) {

	}

	@Override
	public void deleteById(final Long id) {

	}

	@Override
	public boolean exists(final Order order) {
		return false;
	}

	@Override
	public Order get(final Long id) {
		return null;
	}

	@Override
	public List<Order> findAll() {
		return storage;
	}
	
}

package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
	
	private final List<Customer> storage = new LinkedList<>();

	@Override
	public Customer create(final Customer customer) {
		storage.add(customer);
		return null;
	}

	@Override
	public List<Customer> createAll(final List<Customer> customers) {
		storage.addAll(customers);
		return null;
	}

	@Override
	public void update(final Customer customer) {

	}

	@Override
	public void delete(final Customer customer) {

	}

	@Override
	public void deleteById(final Long id) {

	}

	@Override
	public boolean exists(final Customer customer) {
		return false;
	}

	@Override
	public Customer get(final Long id) {
		return null;
	}

	@Override
	public List<Customer> findAll() {
		return storage;
	}
	
	@Override
	public Customer findByEmail(final String email) {
		return null;
	}
}

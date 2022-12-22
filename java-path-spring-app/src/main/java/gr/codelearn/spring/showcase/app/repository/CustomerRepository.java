package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.Customer;

import java.util.List;

public interface CustomerRepository {

	Customer create(Customer customer);

	List<Customer> createAll(List<Customer> customers);

	void update(Customer customer);

	void delete(Customer customer);

	void deleteById(Long id);

	boolean exists(Customer customer);

	Customer get(Long id);

	List<Customer> findAll();
	
	Customer findByEmail(String email);
}

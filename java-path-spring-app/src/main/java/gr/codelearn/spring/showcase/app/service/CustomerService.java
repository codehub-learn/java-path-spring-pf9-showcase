package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Customer;

import java.util.List;

public interface CustomerService {

	Customer create(Customer customer);

	List<Customer> createAll(Customer... customers);

	List<Customer> createAll(List<Customer> customers);

	void update(Customer customer);

	void delete(Customer customer);

	void deleteById(Long id);

	boolean exists(Customer customer);

	List<Customer> findAll();

	Customer find(Long id);

	Customer get(Long id);
	Customer findByEmail(String email);
}

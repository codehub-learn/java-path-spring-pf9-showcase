package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Customer;
import gr.codelearn.spring.showcase.app.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	private final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	private final CustomerRepository customerRepository;

	@Override
	public Customer create(final Customer customer) {
		logger.trace("Creating {}.", customer);
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> createAll(Customer... entities) {
		return createAll(List.of(entities));
	}

	@Override
	public List<Customer> createAll(final List<Customer> customers) {
		final List<Customer> updatedEntities = new ArrayList<>();
		for (final Customer customer : customers) {
			updatedEntities.add(create(customer));
		}
		return updatedEntities;
	}

	@Override
	public void update(final Customer customer) {
		logger.trace("Updating {}.", customer);
		customerRepository.save(customer);
	}

	@Override
	public void delete(final Customer customer) {
		logger.trace("Deleting {}.", customer);
		customerRepository.delete(customer);
	}

	@Override
	public void deleteById(final Long id) {
		final Customer entityFound = customerRepository.getReferenceById(id);
		logger.trace("Deleting {}.", entityFound);
		customerRepository.deleteById(id);
	}

	@Override
	public boolean exists(final Customer customer) {
		logger.trace("Checking whether {} exists.", customer);
		return customerRepository.existsById(customer.getId());
	}

	@Override
	public List<Customer> findAll() {
		logger.trace("Retrieving all data.");
		return customerRepository.findAll();
	}

	@Override
	public Customer find(Long id) {
		return null;
	}

	public Customer get(Long id) {
		return customerRepository.getReferenceById(id);
	}


	@Override
	public Customer findByEmail(final String email) {
		return customerRepository.findAll().stream().filter(c -> c.getEmail().equals(email)).findAny().orElse(null);
	}
}

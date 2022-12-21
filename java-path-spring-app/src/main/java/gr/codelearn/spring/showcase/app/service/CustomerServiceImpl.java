package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Customer;
import gr.codelearn.spring.showcase.app.repository.BaseRepository;
import gr.codelearn.spring.showcase.app.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements CustomerService {
	private final CustomerRepository customerRepository;

	@Override
	BaseRepository<Customer, Long> getRepository() {
		return customerRepository;
	}

	@Override
	public Customer findByEmail(final String email) {
		return customerRepository.findAll().stream().filter(c -> c.getEmail().equals(email)).findAny().orElse(null);
	}
}

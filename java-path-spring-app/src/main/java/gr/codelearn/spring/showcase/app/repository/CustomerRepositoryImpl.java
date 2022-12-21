package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer> implements CustomerRepository {
	@Override
	public Customer findByEmail(final String email) {
		return null;
	}
}

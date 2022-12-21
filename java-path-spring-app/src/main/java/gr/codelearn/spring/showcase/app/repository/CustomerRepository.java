package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.Customer;

public interface CustomerRepository extends BaseRepository<Customer, Long> {
	Customer findByEmail(String email);
}

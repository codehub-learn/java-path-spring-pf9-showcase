package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Customer;

public interface CustomerService extends BaseService<Customer, Long> {
	Customer findByEmail(String email);
}

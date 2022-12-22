package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.Product;

import java.util.List;

public interface ProductRepository {

	Product create(Product product);

	List<Product> createAll(List<Product> products);

	void update(Product product);

	void delete(Product product);

	void deleteById(Long id);

	boolean exists(Product product);

	Product get(Long id);

	List<Product> findAll();
	
	Product findBySerial(String serial);
}

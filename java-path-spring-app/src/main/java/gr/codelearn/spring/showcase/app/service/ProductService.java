package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Category;
import gr.codelearn.spring.showcase.app.domain.Product;

import java.util.List;

public interface ProductService  {

	Product create(Product product);

	List<Product> createAll(Product... products);

	List<Product> createAll(List<Product> products);

	void update(Product product);

	void delete(Product product);

	void deleteById(Long id);

	boolean exists(Product product);

	List<Product> findAll();

	Product find(Long id);

	Product get(Long id);
	
	Product findBySerial(String serial);

	List<Product> findByCategory(Category category);
}

package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	private final List<Product> storage = new LinkedList<>();

	@Override
	public Product create(final Product product) {
		storage.add(product);
		return null;
	}

	@Override
	public List<Product> createAll(final List<Product> products) {
		storage.addAll(products);
		return null;
	}

	@Override
	public void update(final Product product) {

	}

	@Override
	public void delete(final Product product) {

	}

	@Override
	public void deleteById(final Long id) {

	}

	@Override
	public boolean exists(final Product product) {
		return false;
	}

	@Override
	public Product get(final Long id) {
		return null;
	}

	@Override
	public List<Product> findAll() {
		return storage;
	}
	@Override
	public Product findBySerial(final String serial) {
		return null;
	}
}

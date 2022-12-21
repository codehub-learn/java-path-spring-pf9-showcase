package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl extends BaseRepositoryImpl<Product> implements ProductRepository {
	@Override
	public Product findBySerial(final String serial) {
		return null;
	}
}

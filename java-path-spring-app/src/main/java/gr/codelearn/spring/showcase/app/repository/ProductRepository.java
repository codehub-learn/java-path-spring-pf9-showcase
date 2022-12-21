package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.Product;

public interface ProductRepository extends BaseRepository<Product, Long> {
	Product findBySerial(String serial);
}

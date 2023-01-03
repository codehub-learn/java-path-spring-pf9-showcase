package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Category;
import gr.codelearn.spring.showcase.app.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService extends BaseService<Product, Long> {

	Product findBySerial(String serial);

	List<Product> findByCategory(Category category);

	List<Product> findProductsCostingMoreThan(BigDecimal price);

}

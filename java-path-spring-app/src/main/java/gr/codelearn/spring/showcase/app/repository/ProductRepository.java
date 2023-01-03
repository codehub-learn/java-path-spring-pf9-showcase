package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.Category;
import gr.codelearn.spring.showcase.app.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findBySerial(String serial);

	List<Product> findAllByCategory(Category category);

	@Query(value = "SELECT * from PRODUCTS WHERE PRICE >= :price", nativeQuery = true)
	List<Product> findProductsMoreExpensiveThanSQL(@Param("price") BigDecimal price);

}

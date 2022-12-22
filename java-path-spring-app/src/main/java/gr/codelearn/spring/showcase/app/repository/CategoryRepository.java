package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.Category;

import java.util.List;

public interface CategoryRepository {

	Category create(Category category);

	List<Category> createAll(List<Category> categories);

	void update(Category category);

	void delete(Category category);

	void deleteById(Long id);

	boolean exists(Category category);

	Category get(Long id);

	List<Category> findAll();
	
	Category findByDescription(String description);
}

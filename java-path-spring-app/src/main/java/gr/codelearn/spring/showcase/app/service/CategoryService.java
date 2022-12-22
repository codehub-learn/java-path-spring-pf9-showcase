package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Category;

import java.util.List;

public interface CategoryService {

	Category create(Category category);

	List<Category> createAll(Category... categories);

	List<Category> createAll(List<Category> categories);

	void update(Category category);

	void delete(Category category);

	void deleteById(Long id);

	boolean exists(Category category);

	List<Category> findAll();

	Category find(Long id);

	Category get(Long id);
	
	Category findByDescription(String description);
}

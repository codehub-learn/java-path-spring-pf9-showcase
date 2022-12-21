package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Category;

public interface CategoryService extends BaseService<Category, Long> {
	Category findByDescription(String description);
}

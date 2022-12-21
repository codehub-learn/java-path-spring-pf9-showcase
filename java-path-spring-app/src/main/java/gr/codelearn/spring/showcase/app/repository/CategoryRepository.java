package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.Category;

public interface CategoryRepository extends BaseRepository<Category, Long> {
	Category findByDescription(String description);
}

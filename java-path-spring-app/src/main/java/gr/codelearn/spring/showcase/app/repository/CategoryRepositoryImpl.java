package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepositoryImpl extends BaseRepositoryImpl<Category> implements CategoryRepository {
	@Override
	public Category findByDescription(final String description) {
		return null;
	}
}

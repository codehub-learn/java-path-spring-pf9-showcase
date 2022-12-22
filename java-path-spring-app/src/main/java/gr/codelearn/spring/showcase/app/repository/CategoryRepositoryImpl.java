package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.Category;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

	private final List<Category> storage = new LinkedList<>();

	@Override
	public Category create(final Category category) {
		storage.add(category);
		return null;
	}

	@Override
	public List<Category> createAll(final List<Category> categories) {
		storage.addAll(categories);
		return null;
	}

	@Override
	public void update(final Category category) {

	}

	@Override
	public void delete(final Category category) {

	}

	@Override
	public void deleteById(final Long id) {

	}

	@Override
	public boolean exists(final Category category) {
		return false;
	}

	@Override
	public Category get(final Long id) {
		return null;
	}

	@Override
	public List<Category> findAll() {
		return storage;
	}

	@Override
	public Category findByDescription(final String description) {
		return null;
	}
}

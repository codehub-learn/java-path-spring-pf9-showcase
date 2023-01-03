package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Category;
import gr.codelearn.spring.showcase.app.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	private final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
	private final CategoryRepository categoryRepository;
	
	@Override
	public Category create(final Category category) {
		logger.trace("Creating {}.", category);
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> createAll(Category... entities) {
		return createAll(List.of(entities));
	}

	@Override
	public List<Category> createAll(final List<Category> categories) {
		final List<Category> updatedEntities = new ArrayList<>();
		for (final Category category : categories) {
			updatedEntities.add(create(category));
		}
		return updatedEntities;
	}

	@Override
	public void update(final Category category) {
		logger.trace("Updating {}.", category);
		categoryRepository.save(category);
	}

	@Override
	public void delete(final Category category) {
		logger.trace("Deleting {}.", category);
		categoryRepository.delete(category);
	}

	@Override
	public void deleteById(final Long id) {
		final Category entityFound = categoryRepository.getReferenceById(id);
		logger.trace("Deleting {}.", entityFound);
		categoryRepository.deleteById(id);
	}

	@Override
	public boolean exists(final Category category) {
		logger.trace("Checking whether {} exists.", category);
		return categoryRepository.existsById(category.getId());
	}

	@Override
	public List<Category> findAll() {
		logger.trace("Retrieving all data.");
		return categoryRepository.findAll();
	}

	@Override
	public Category find(Long id) {
		return null;
	}

	public Category get(Long id) {
		return categoryRepository.getReferenceById(id);
	}

	@Override
	public Category findByDescription(final String description) {
		return categoryRepository.findAll().stream().filter(c -> c.getDescription().equals(description)).findAny()
								 .orElse(null);
	}
}

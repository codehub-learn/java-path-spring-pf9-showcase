package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Category;
import gr.codelearn.spring.showcase.app.repository.BaseRepository;
import gr.codelearn.spring.showcase.app.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {
	private final CategoryRepository categoryRepository;

	@Override
	BaseRepository<Category, Long> getRepository() {
		return categoryRepository;
	}

	@Override
	public Category findByDescription(final String description) {
		return categoryRepository.findAll().stream().filter(c -> c.getDescription().equals(description)).findAny()
								 .orElse(null);
	}
}

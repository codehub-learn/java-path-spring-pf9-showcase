package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Category;
import gr.codelearn.spring.showcase.app.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

	private final CategoryRepository categoryRepository;

	@Override
	JpaRepository<Category, Long> getRepository() {
		return categoryRepository;
	}


	@Override
	public Category findByDescription(final String description) {
		return Optional.ofNullable(categoryRepository.findByDescription(description)).orElseThrow(
				NoSuchElementException::new);
	}
}

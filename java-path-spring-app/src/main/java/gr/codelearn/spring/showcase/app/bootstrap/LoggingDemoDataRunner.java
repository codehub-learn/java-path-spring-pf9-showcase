package gr.codelearn.spring.showcase.app.bootstrap;

import gr.codelearn.spring.showcase.app.base.AbstractLogComponent;
import gr.codelearn.spring.showcase.app.domain.Category;
import gr.codelearn.spring.showcase.app.service.CategoryService;
import gr.codelearn.spring.showcase.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Profile("logging-data-demo")
public class LoggingDemoDataRunner extends AbstractLogComponent implements CommandLineRunner {

	private final CategoryService categoryService;

	private final ProductService productService;

	@Override
	public void run(final String... args) throws Exception {
		logger.info("=============================");
		logger.info("====Finding Category by Id====");
		Category foundCategory = categoryService.find(1L);
		Optional.ofNullable(foundCategory).ifPresent(category -> logger.info(category.toString()));
		logger.info("=============================");
		logger.info("=============================");

		logger.info("=============================");
		logger.info("====Finding All Categories====");
		categoryService.findAll().forEach(category -> logger.info(category.toString()));
		logger.info("=============================");
		logger.info("=============================");

		logger.info("=============================");
		logger.info("====Finding Category By Description ====");
		logger.info(categoryService.findByDescription("Mobile Phones").toString());
		logger.info("=============================");
		logger.info("=============================");

		logger.info("=============================");
		logger.info("====Finding Product by Category ====");
		Optional.ofNullable(foundCategory).ifPresent(
				category -> productService.findByCategory(foundCategory).forEach(p -> logger.info(p.toString())));
		logger.info("=============================");
		logger.info("=============================");
	}

}

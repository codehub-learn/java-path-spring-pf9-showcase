package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Product;
import gr.codelearn.spring.showcase.app.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	private final ProductRepository productRepository;

	@Override
	public Product create(final Product product) {
		logger.trace("Creating {}.", product);
		return productRepository.save(product);
	}

	@Override
	public List<Product> createAll(Product... entities) {
		return createAll(List.of(entities));
	}

	@Override
	public List<Product> createAll(final List<Product> products) {
		final List<Product> updatedEntities = new ArrayList<>();
		for (final Product product : products) {
			updatedEntities.add(create(product));
		}
		return updatedEntities;
	}

	@Override
	public void update(final Product product) {
		logger.trace("Updating {}.", product);
		productRepository.save(product);
	}

	@Override
	public void delete(final Product product) {
		logger.trace("Deleting {}.", product);
		productRepository.delete(product);
	}

	@Override
	public void deleteById(final Long id) {
		final Product entityFound = productRepository.getReferenceById(id);
		logger.trace("Deleting {}.", entityFound);
		productRepository.deleteById(id);
	}

	@Override
	public boolean exists(final Product product) {
		logger.trace("Checking whether {} exists.", product);
		return productRepository.existsById(product.getId());
	}

	@Override
	public List<Product> findAll() {
		logger.trace("Retrieving all data.");
		return productRepository.findAll();
	}

	@Override
	public Product find(Long id) {
		return null;
	}

	public Product get(Long id) {
		return productRepository.getReferenceById(id);
	}


	@Override
	public Product findBySerial(final String serial) {
		return productRepository.findAll().stream().filter(c -> c.getSerial().equals(serial)).findAny().orElse(null);
	}
}

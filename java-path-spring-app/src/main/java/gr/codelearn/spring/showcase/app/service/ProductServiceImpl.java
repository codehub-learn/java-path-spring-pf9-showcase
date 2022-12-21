package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Product;
import gr.codelearn.spring.showcase.app.repository.BaseRepository;
import gr.codelearn.spring.showcase.app.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {
	private final ProductRepository productRepository;

	@Override
	BaseRepository<Product, Long> getRepository() {
		return productRepository;
	}

	@Override
	public Product findBySerial(final String serial) {
		return productRepository.findAll().stream().filter(c -> c.getSerial().equals(serial)).findAny().orElse(null);
	}
}

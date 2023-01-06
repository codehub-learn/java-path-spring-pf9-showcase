package gr.codelearn.spring.showcase.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import gr.codelearn.spring.showcase.app.domain.Product;
import gr.codelearn.spring.showcase.app.mapper.BaseMapper;
import gr.codelearn.spring.showcase.app.mapper.ProductMapper;
import gr.codelearn.spring.showcase.app.service.BaseService;
import gr.codelearn.spring.showcase.app.service.ProductService;
import gr.codelearn.spring.showcase.app.transfer.ApiResponse;
import gr.codelearn.spring.showcase.app.transfer.resource.ProductResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController extends BaseController<Product, ProductResource> {
	private final ProductService productService;
	private final ProductMapper productMapper;

	@Override
	protected BaseService<Product, Long> getBaseService() {
		return productService;
	}

	@Override
	protected BaseMapper<Product, ProductResource> getBaseMapper() {
		return productMapper;
	}

	@GetMapping(path = "/{pId}/support/{sId}", params = {"x=10", "y=100"})
	public ResponseEntity<ApiResponse<String>> mappingExample(
			@PathVariable(value = "sId", required = false) String supportId, @PathVariable("pId") Long productId,
			@RequestParam("value") String value, HttpServletRequest request) {
		return ResponseEntity.ok(
				ApiResponse.<String>builder().data(productId.toString() + "->" + supportId + "->" + value).build());
	}

	@GetMapping(headers = "filtered")
	public ResponseEntity<ApiResponse<JsonNode>> filteredProduct() {
		Product product = getBaseService().findAll().get(0);
		return ResponseEntity.ok(
				ApiResponse.<JsonNode>builder().data(filterProducts(product, "price", "serial")).build());
	}

	private JsonNode filterProducts(Product product, String... excludedFields) {
		SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider();
		SimpleFilterProvider filters = simpleFilterProvider.addFilter("product_filter",
																	  SimpleBeanPropertyFilter.serializeAllExcept(
																			  excludedFields));

		// Local object mapper that will convert our product to a string based on the given filter
		ObjectMapper mapper = new ObjectMapper();
		mapper.setFilterProvider(filters);
		ObjectWriter writer = mapper.writer();
		final String filteredJsonAsString;
		try {
			// Converting to string to filter out attributes we have excluded
			filteredJsonAsString = writer.writeValueAsString(product);
			return mapper.readTree(filteredJsonAsString);
		} catch (JsonProcessingException e) {
			// Will be caught by the exception handler which handles generic exceptions
			throw new RuntimeException("Json processing has failed");
		}
	}
}

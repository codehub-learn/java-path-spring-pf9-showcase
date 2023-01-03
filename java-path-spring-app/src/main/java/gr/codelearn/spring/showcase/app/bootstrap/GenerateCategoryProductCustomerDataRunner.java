package gr.codelearn.spring.showcase.app.bootstrap;

import gr.codelearn.spring.showcase.app.base.AbstractLogComponent;
import gr.codelearn.spring.showcase.app.domain.Category;
import gr.codelearn.spring.showcase.app.domain.Customer;
import gr.codelearn.spring.showcase.app.domain.Product;
import gr.codelearn.spring.showcase.app.domain.enumeration.CustomerCategory;
import gr.codelearn.spring.showcase.app.service.CategoryService;
import gr.codelearn.spring.showcase.app.service.CustomerService;
import gr.codelearn.spring.showcase.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@Profile("base-content-creator")
@RequiredArgsConstructor
public class GenerateCategoryProductCustomerDataRunner extends AbstractLogComponent implements CommandLineRunner {
	private final ProductService productService;
	private final CategoryService categoryService;
	private final CustomerService customerService;

	@Override
	public void run(String... args) throws Exception {
		Category newCategory = categoryService.create(Category.builder().description("Mobile Phones").build());
		logger.info("Created {}.", newCategory);

		//@formatter:off
		List<Product> products = List.of(
				Product.builder().serial("SN1000-0001").name("Apple iPhone 12 Pro 5G 512GB")
						.price(BigDecimal.valueOf(1629)).category(newCategory).build(),
				Product.builder().serial("SN1000-0002").name("Apple iPhone 12 Pro Max 5G 512GB")
						.price(BigDecimal.valueOf(1749)).category(newCategory).build(),
				Product.builder().serial("SN1100-0001").name("Samsung Galaxy S21 Ultra")
						.price(BigDecimal.valueOf(1479.99)).category(newCategory).build(),
				Product.builder().serial("SN1100-0002").name("Samsung Galaxy S20 Ultra")
						.price(BigDecimal.valueOf(1199)).category(newCategory).build(),
				Product.builder().serial("SN1200-0001").name("Huawei P40 Pro")
						.price(BigDecimal.valueOf(899.49)).category(newCategory).build(),
				Product.builder().serial("SN1300-0001").name("Xiaomi Redmi 9A")
						.price(BigDecimal.valueOf(199.75)).category(newCategory).build(),
				Product.builder().serial("SN1400-0001").name("RealMe C11")
						.price(BigDecimal.valueOf(129)).category(newCategory).build(),
				Product.builder().serial("SN1500-0001").name("Honor 10 Lite")
						.price(BigDecimal.valueOf(179)).category(newCategory).build(),
				Product.builder().serial("SN1000-0003").name("Apple iPhone 12 Pro Max 5G 128GB")
						.price(BigDecimal.valueOf(1339)).category(newCategory).build(),
				Product.builder().serial("SN1000-0004").name("Apple iPhone 11 Pro 256GB")
						.price(BigDecimal.valueOf(1299.99)).category(newCategory).build()
		);

		logger.info("Created {} products.", productService.createAll(products).size());

		List<Customer> customers = customerService.createAll(
				Customer.builder().email("c.giannacoulis@codehub.gr")
						.firstname("Constantinos").lastname("Giannacoulis")
						.address("3583 Tennessee Avenue")
						.customerCategory(CustomerCategory.INDIVIDUAL).age(47).build(),
				Customer.builder().email("john.porter@gmail.com")
						.firstname("John").lastname("Porter")
						.address("2955 Blackwell Street")
						.customerCategory(CustomerCategory.BUSINESS).age(40).build(),
				Customer.builder().email("malcolm.paker@gmail.com")
						.firstname("Malcolm").lastname("Parker")
						.address("4071 Kelly Drive")
						.customerCategory(CustomerCategory.GOVERNMENT).age(32).build(),
				Customer.builder().email("terry.jones@gmail.com")
						.firstname("Terry").lastname("Jones")
						.address("3849 Hinkle Lake Road")
						.customerCategory(CustomerCategory.BUSINESS).age(57).build(),
				Customer.builder().email("peter.mercury@outlook.com")
						.firstname("Peter").lastname("Mercury")
						.address("Freddie Street 28th")
						.customerCategory(CustomerCategory.INDIVIDUAL).age(32).build(),
				Customer.builder().email("magdalene.ferguson@gmail.com")
						.firstname("Magdalene").lastname("Ferguson")
						.address("Jelly Avenue 73")
						.customerCategory(CustomerCategory.INDIVIDUAL).age(32).build(),
				Customer.builder().email("jones.pirves@gmail.com")
						.firstname("Jones").lastname("Pirves")
						.address("3rd Mountain Hike, 3")
						.customerCategory(CustomerCategory.INDIVIDUAL).age(32).build(),
				Customer.builder().email("michael.anderson@gmail.com")
						.firstname("Michael").lastname("Anderson")
						.address("Hollywood Street 63")
						.customerCategory(CustomerCategory.BUSINESS).age(32).build(),
				Customer.builder().email("yennefer.lawrance@windowslive.com")
						.firstname("Yennefer").lastname("Lawrance")
						.address("Rivia 43")
						.customerCategory(CustomerCategory.BUSINESS).age(32).build(),
				Customer.builder().email("mary.ferry@windowslive.com")
						.firstname("Mary").lastname("Ferry")
						.address("Downtown 17, California")
						.customerCategory(CustomerCategory.GOVERNMENT).age(32).build());
		//@formatter:on

		logger.info("Customers created: {}.", customerService.findAll());
	}
}

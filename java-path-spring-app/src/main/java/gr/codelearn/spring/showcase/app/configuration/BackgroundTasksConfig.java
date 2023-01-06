package gr.codelearn.spring.showcase.app.configuration;

import gr.codelearn.spring.showcase.app.domain.Order;
import gr.codelearn.spring.showcase.app.repository.CustomerRepository;
import gr.codelearn.spring.showcase.app.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableScheduling
public class BackgroundTasksConfig {

	private static final Logger LOG = LoggerFactory.getLogger(BackgroundTasksConfig.class);

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	OrderRepository orderRepository;

	@Scheduled(initialDelay = 20, fixedRate = 20, timeUnit = TimeUnit.SECONDS)
	public void logNumberOfCustomers() {
		LOG.info("Total customers at ({}): {}", LocalDateTime.now(), customerRepository.count());
	}

	@Scheduled(cron = "0/30 * * ? * * ")
	public void logNumberOfNewOrders() {
		final long newOrdersToday = orderRepository.findAll().stream().filter(
				order -> LocalDateTime.ofInstant(order.getSubmitDate().toInstant(), ZoneId.systemDefault())
						.isAfter(LocalDate.now().atStartOfDay())).count();
		LOG.info("Pending orders today ({}): {}", LocalDate.now(), newOrdersToday);
	}

	@Scheduled(cron = "0/30 * * ? * * ")
	public void logTotalValueOfOrders() {
		final BigDecimal newOrdersToday = orderRepository.findAll().stream().map(Order::getCost).reduce(BigDecimal.ZERO, BigDecimal::add);
		LOG.info("Total order value today ({}): {}", LocalDate.now(), newOrdersToday);
	}
}

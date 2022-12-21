package gr.codelearn.spring.showcase.core.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Bootstrap class demonstrating the property retrieval from two distinctive sources. It runs only once during
 * application initialization.
 */
@Component
public class SampleRunner implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(SampleRunner.class);

	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${server.port}")
	private String serverPort;

	@Override
	public void run(final String... args) throws Exception {
		logger.info("Application named '{}' is being started at port {}", applicationName, serverPort);
	}

}

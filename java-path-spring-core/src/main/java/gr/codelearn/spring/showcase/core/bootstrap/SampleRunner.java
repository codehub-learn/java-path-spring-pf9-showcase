package gr.codelearn.spring.showcase.core.bootstrap;

import gr.codelearn.spring.showcase.core.config.MappedConfigurationProperties;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Bootstrap class demonstrating the property retrieval from two distinctive sources. It runs only once during
 * application initialization.
 */
@Component
@RequiredArgsConstructor
@Profile({"dev", "prod"})
public class SampleRunner implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(SampleRunner.class);

	private final MappedConfigurationProperties mappedConfigurationProperties;

	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${server.port}")
	private String serverPort;

	@Value("${my.custom.property}")
	private String myCustomProperty;

	@Override
	public void run(final String... args) throws Exception {
		logger.info("Application named '{}' is being started at port {} and custom property {} ", applicationName,
					serverPort, myCustomProperty);

		// Retrieves information from YAML file
		logger.info("Current threadPool value is {}.", mappedConfigurationProperties.getThreadPool());
		logger.info("Support email is {}.", mappedConfigurationProperties.getEmail());
		logger.info("Target server are {}.", mappedConfigurationProperties.getServers());

	}

}

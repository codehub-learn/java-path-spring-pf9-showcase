package gr.codelearn.spring.showcase.core.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DieselEngine implements Engine {

	private final Logger logger = LoggerFactory.getLogger(DieselEngine.class);

	@Override
	public void ignite() {
		logger.info("Starting Diesel Engine");
	}
}

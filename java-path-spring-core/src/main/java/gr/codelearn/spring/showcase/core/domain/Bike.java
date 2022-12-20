package gr.codelearn.spring.showcase.core.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bike implements Vehicle{
	private final Logger logger = LoggerFactory.getLogger(Bike.class);

	@Override
	public void start() {
		logger.info("Travelling by Bike");
	}

}

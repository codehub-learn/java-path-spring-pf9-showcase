package gr.codelearn.spring.showcase.core.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bike {
	private final Logger logger = LoggerFactory.getLogger(Bike.class);

	public void ride() {
		logger.info("Travelling by Bike");
	}

}

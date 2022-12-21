package gr.codelearn.spring.showcase.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
@Builder
@AllArgsConstructor
public class Car implements Vehicle{
	private final Logger logger = LoggerFactory.getLogger(Car.class);

	private final String make;

	@Override
	public void start() {
		logger.info("Travelling by Car");
	}


}

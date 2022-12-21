package gr.codelearn.spring.showcase.core.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
@Builder
@NoArgsConstructor
public class Car implements Vehicle{

	private final Logger logger = LoggerFactory.getLogger(Car.class);

	@Override
	public void start() {
		logger.info("Travelling by Car");
	}


}

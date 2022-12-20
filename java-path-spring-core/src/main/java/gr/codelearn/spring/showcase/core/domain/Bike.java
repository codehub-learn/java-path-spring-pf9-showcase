package gr.codelearn.spring.showcase.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bike implements Vehicle{
	private final Logger logger = LoggerFactory.getLogger(Bike.class);

	private Engine engine;

	@Override
	public void start() {
		logger.info("Travelling by Bike");
		engine.ignite();
	}

}
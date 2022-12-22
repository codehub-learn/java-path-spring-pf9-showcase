package gr.codelearn.spring.showcase.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Bike implements Vehicle{
	private final Logger logger = LoggerFactory.getLogger(Bike.class);

	@Autowired
	private Engine engine;

	@Override
	public void start() {
		logger.info("Travelling by Bike");
		engine.ignite();
	}

}

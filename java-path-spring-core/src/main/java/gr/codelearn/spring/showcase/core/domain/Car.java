package gr.codelearn.spring.showcase.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@Builder
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@AllArgsConstructor
public class Car implements Vehicle{
	private final Logger logger = LoggerFactory.getLogger(Car.class);

	private final String make;
	@Autowired
	private Engine engine;

	@Override
	public void start() {
		logger.info("Travelling by Car");
		engine.ignite();
	}


}

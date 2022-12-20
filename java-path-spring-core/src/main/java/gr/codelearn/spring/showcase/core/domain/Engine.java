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
public class Engine {

	private final Logger logger = LoggerFactory.getLogger(Engine.class);

	private String cc;
	private EngineType engineType;

	public void ignite() {
		logger.info("Starting engine of type {}", this.engineType);
	}

}

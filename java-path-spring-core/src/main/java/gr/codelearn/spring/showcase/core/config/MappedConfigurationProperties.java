package gr.codelearn.spring.showcase.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties("myproperties")
public class MappedConfigurationProperties {
	private int threadPool;
	private String email;
	private List<String> servers;
}

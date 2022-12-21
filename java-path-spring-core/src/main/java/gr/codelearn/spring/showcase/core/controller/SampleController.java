package gr.codelearn.spring.showcase.core.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@Value("${spring.application.name}")
	private String applicationName;

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello from our sample Spring Boot with name: " + applicationName;
	}
}

package gr.codelearn.spring.showcase.core.config;

import gr.codelearn.spring.showcase.core.domain.Bike;
import gr.codelearn.spring.showcase.core.domain.Car;
import gr.codelearn.spring.showcase.core.domain.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VehicleConfig {

	@Bean
	public Vehicle beanConfiguredCar(){
		return new Car();
	}

	@Bean(name = "bike")
	public Vehicle beanConfiguredBike(){
		return new Bike();
	}

}

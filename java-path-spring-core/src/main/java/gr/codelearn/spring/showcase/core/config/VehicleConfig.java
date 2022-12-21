package gr.codelearn.spring.showcase.core.config;

import gr.codelearn.spring.showcase.core.domain.Bike;
import gr.codelearn.spring.showcase.core.domain.Car;
import gr.codelearn.spring.showcase.core.domain.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VehicleConfig {

	@Bean
	public Vehicle car(){
		return new Car("beanCar");
	}
	@Bean
	public Vehicle beanConfiguredCar(){
		return new Car("beanCar");
	}

	@Bean(name = "bike")
	public Vehicle beanConfiguredBike(){
		return new Bike();
	}

	@Bean(name = "suzukiVstrom")
	public Bike suzukiVstrom() {
		return new Bike();
	}

	@Bean
	public Vehicle toyotaYaris(){
		return new Car("Toyota");
	}

	@Bean
	public Vehicle renaultClio(){
		return new Car("Renault");
	}


}

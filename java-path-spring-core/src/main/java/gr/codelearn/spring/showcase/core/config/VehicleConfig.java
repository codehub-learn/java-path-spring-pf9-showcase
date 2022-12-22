package gr.codelearn.spring.showcase.core.config;

import gr.codelearn.spring.showcase.core.domain.Bike;
import gr.codelearn.spring.showcase.core.domain.Car;
import gr.codelearn.spring.showcase.core.domain.DieselEngine;
import gr.codelearn.spring.showcase.core.domain.Engine;
import gr.codelearn.spring.showcase.core.domain.PetrolEngine;
import gr.codelearn.spring.showcase.core.domain.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class VehicleConfig {

	@Bean
	@Profile({"diesel", "default"})
	public Engine dieselEngine() {
		return new DieselEngine();
	}

	@Bean
	@Profile("petrol")
	public Engine petrolEngine() {
		return new PetrolEngine();
	}

	@Bean
	public Vehicle car(){
		return new Car("beanCar");
	}
	@Bean
	public Vehicle beanConfiguredCar(){
		return new Car("beanCar");
	}

 	@Bean
	public Vehicle toyotaYaris(){
		return new Car("Toyota");
	}

	@Bean
	public Vehicle renaultClio(){
		return new Car("Renault");
	}

	@Bean(name = "bike")
	public Vehicle beanConfiguredBike(){
		return new Bike();
	}

	@Bean(name = "suzukiVstrom")
	public Bike suzukiVstrom() {
		return new Bike();
	}



}

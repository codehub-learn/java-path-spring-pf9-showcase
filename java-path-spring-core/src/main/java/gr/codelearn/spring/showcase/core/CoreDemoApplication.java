package gr.codelearn.spring.showcase.core;

import gr.codelearn.spring.showcase.core.domain.Bike;
import gr.codelearn.spring.showcase.core.domain.Car;
import gr.codelearn.spring.showcase.core.domain.Vehicle;
import gr.codelearn.spring.showcase.core.service.TravelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CoreDemoApplication {
	//remember to perform a clean after adding logging configuration, before executing class
	private static final Logger logger = LoggerFactory.getLogger(CoreDemoApplication.class);

	public static void main(String[] args) {
		logger.info("Starting program execution");

		ApplicationContext context = SpringApplication.run(CoreDemoApplication.class, args);

		/*
			this bean is still being picked up, although not present in VehicleConfig, but annotated with @Component,
			due to @SpringBootApplication component scanning
		*/
		Vehicle vehicle = context.getBean("car", Car.class);
		TravelService anotherTravel = new TravelService(vehicle);
		anotherTravel.startJourney();

		/*
			Scanned in VehicleConfig
		 */
		vehicle = context.getBean("beanConfiguredCar", Car.class);
		TravelService myTravel = new TravelService(vehicle);
		myTravel.startJourney();

		/*
			Scanned in VehicleConfig, no @Component in Bike class
		 */
		vehicle = context.getBean("bike", Bike.class);
		TravelService anotherTravel2 = new TravelService(vehicle);
		anotherTravel2.startJourney();
	}

}

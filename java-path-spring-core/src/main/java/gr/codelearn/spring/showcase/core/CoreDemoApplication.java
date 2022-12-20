package gr.codelearn.spring.showcase.core;

import gr.codelearn.spring.showcase.core.domain.Bike;
import gr.codelearn.spring.showcase.core.domain.Car;
import gr.codelearn.spring.showcase.core.domain.Vehicle;
import gr.codelearn.spring.showcase.core.service.TravelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CoreDemoApplication {
	//remember to perform a clean after adding logging configuration, before executing class
	private static final Logger logger = LoggerFactory.getLogger(CoreDemoApplication.class);

	public static void main(String[] args) {
		logger.info("Starting program execution");

		ApplicationContext context = new AnnotationConfigApplicationContext("gr.codelearn.spring.showcase.core");

		Vehicle vehicle = context.getBean("car", Car.class);
		TravelService myTravel = new TravelService(vehicle);
		myTravel.startJourney();

		vehicle = context.getBean("bike", Bike.class);
		TravelService anotherTravel = new TravelService(vehicle);
		anotherTravel.startJourney();
	}

}

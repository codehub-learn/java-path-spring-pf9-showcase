package gr.codelearn.spring.showcase.core;

import gr.codelearn.spring.showcase.core.domain.Bike;
import gr.codelearn.spring.showcase.core.domain.Car;
import gr.codelearn.spring.showcase.core.domain.Vehicle;
import gr.codelearn.spring.showcase.core.service.AutowiredInjectedTravelService;
import gr.codelearn.spring.showcase.core.service.ConstructorInjectedTravelService;
import gr.codelearn.spring.showcase.core.service.SetterInjectedTravelService;
import gr.codelearn.spring.showcase.core.service.TravelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoreDemoApplication {
	//remember to perform a clean after adding logging configuration, before executing class
	private static final Logger logger = LoggerFactory.getLogger(CoreDemoApplication.class);

	public static void main(String[] args) {
		logger.info("Starting program execution");

		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		/*
			this bean is still being picked up, although not present in VehicleConfig, but annotated with @Component,
			due to @SpringBootApplication component scanning
		*/
		Vehicle vehicle = context.getBean("car", Car.class);
		TravelService anotherTravel = new TravelService(vehicle);
		anotherTravel.startJourney();

//		/*
//			Scanned in VehicleConfig
//		 */
//		vehicle = context.getBean("beanConfiguredCar", Car.class);
//		TravelService myTravel = new TravelService(vehicle);
//		myTravel.startJourney();

		/*
			Scanned in VehicleConfig, no @Component in Bike class
		 */
		vehicle = context.getBean("bike", Bike.class);
		TravelService anotherTravel2 = new TravelService(vehicle);
		anotherTravel2.startJourney();

		//DI with constructor
		ConstructorInjectedTravelService constructorInjectedTravel = context.getBean("constructorInjectedTravel",
																			   ConstructorInjectedTravelService.class);
		constructorInjectedTravel.startJourney();

		//DI with setter
		SetterInjectedTravelService setterInjectedTravel = context.getBean("setterInjectedTravel", SetterInjectedTravelService.class);
		setterInjectedTravel.startJourney();

		//DI with autowire will use constructor or setter
		AutowiredInjectedTravelService autowiredInjectedTravel = context.getBean("autowiredInjectedTravel", AutowiredInjectedTravelService.class);
		autowiredInjectedTravel.startJourney();
	}

}

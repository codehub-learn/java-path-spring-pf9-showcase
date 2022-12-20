package gr.codelearn.spring.showcase.core;

import gr.codelearn.spring.showcase.core.domain.Bike;
import gr.codelearn.spring.showcase.core.domain.Car;
import gr.codelearn.spring.showcase.core.domain.Engine;
import gr.codelearn.spring.showcase.core.domain.EngineType;
import gr.codelearn.spring.showcase.core.service.TravelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoreDemoApplication {
	//remember to perform a clean after adding logging configuration, before executing class
	private static final Logger logger = LoggerFactory.getLogger(CoreDemoApplication.class);

	public static void main(String[] args) {
		logger.info("Starting program execution");

		/*	Attempting to start a travel with a vehicle without an engine, will provide a null pointer exception.
			This main method, pretending to be the container providing the dependencies, is delegated to provide
			all needed dependencies for a travel to be performed
		*/

		//TravelService myTravel = new TravelService(new Car());
		TravelService myTravel = new TravelService(
				Car.builder().engine(Engine.builder().engineType(EngineType.DIESEL).build()).build());
		myTravel.startJourney();

		//TravelService anotherTravel = new TravelService(new Bike());
		TravelService anotherTravel = new TravelService(
				Bike.builder().engine(Engine.builder().engineType(EngineType.ELECTRIC).build()).build());
		anotherTravel.startJourney();
	}

}

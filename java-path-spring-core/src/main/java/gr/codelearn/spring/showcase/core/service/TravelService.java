package gr.codelearn.spring.showcase.core.service;

import gr.codelearn.spring.showcase.core.domain.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TravelService {
	private final Logger logger = LoggerFactory.getLogger(TravelService.class);
	/*
		We need to initiliaze Car, or Bike, or any other Vehicle object with all its properties right at this point,
		ensuring appropriate instantiation
	*/
	Car car = new Car();
	//Bike bike = new Bike();

	public void startJourney() {

		logger.info("Initiating Travel");
		car.drive();
		//bike.ride();
        /*
            What should happen in order to make a journey by Bike?
            How is Travel coupled with the various vehicles?
         */
	}


}

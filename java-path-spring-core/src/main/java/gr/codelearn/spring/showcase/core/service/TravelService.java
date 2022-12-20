package gr.codelearn.spring.showcase.core.service;

import gr.codelearn.spring.showcase.core.domain.Car;
import gr.codelearn.spring.showcase.core.domain.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TravelService {
	private final Logger logger = LoggerFactory.getLogger(TravelService.class);
	/*
	   Instead of creating an instance of specific type, we create one of an interface one,
	   allowing many objects implementing Vehicle interface to be injected
	*/
	Vehicle myVehicle;

	public void setMyVehicle(Vehicle myVehicle) {
		this.myVehicle = myVehicle;
	}

	/*
		It's not responsibility of the service to instantiate any kind of Vehicle, but only get one from outside
	 */
	public void startJourney() {
		logger.info("Initiating Travel");
		myVehicle.start();
	}

}

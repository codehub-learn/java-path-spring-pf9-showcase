package gr.codelearn.spring.showcase.core.service;

import gr.codelearn.spring.showcase.core.domain.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TravelServiceImpl implements TravelService {

	private static final Logger logger = LoggerFactory.getLogger(TravelServiceImpl.class);

	/*
	   Instead of creating an instance of specific type, we create one of an interface one,
	   allowing many objects implementing Vehicle interface to be injected
	*/
	private Vehicle myVehicle;

	public TravelServiceImpl(final Vehicle myVehicle) {
		this.myVehicle = myVehicle;
	}

	public void startJourney() {
		logger.info("Initiating Travel");
		myVehicle.start();
	}

}

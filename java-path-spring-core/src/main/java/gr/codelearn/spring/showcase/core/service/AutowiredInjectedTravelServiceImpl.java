package gr.codelearn.spring.showcase.core.service;

import gr.codelearn.spring.showcase.core.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AutowiredInjectedTravelServiceImpl implements TravelService {

	//This is the dependency
	//No setter or constructor is needed
	//We need this annotation here to know where to Autowire
	@Autowired
	@Qualifier("renaultClio")
	private Vehicle vehicle;

	public void startJourney() {
		vehicle.start();
	}

}


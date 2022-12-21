package gr.codelearn.spring.showcase.core.service;

import gr.codelearn.spring.showcase.core.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ConstructorInjectedTravelService {

	//This is the dependency
	private Vehicle vehicle;

	//I'm injecting the dependency with through the constructor
	@Autowired
	public ConstructorInjectedTravelService(@Qualifier("car") Vehicle vehicle) {
		this.vehicle = vehicle;
		System.out.println("Using Constructor Injection");
	}

	public void startJourney() {
		vehicle.start();
	}

}


package gr.codelearn.spring.showcase.core.service;

import gr.codelearn.spring.showcase.core.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SetterInjectedTravelService {

	//This is the dependency
	private Vehicle vehicle;

	//I'm injecting the dependency with a setter
	@Autowired
	public void setVehicle(@Qualifier("car") Vehicle vehicle) {
		this.vehicle = vehicle;
		System.out.println("Using Setter Injection");
	}

	public void startJourney() {
		vehicle.start();
	}

}


package gr.codelearn.spring.showcase.core.service;

import gr.codelearn.spring.showcase.core.domain.Vehicle;

public class ConstructorInjectedTravelService {

	//This is the dependency
	private Vehicle vehicle;

	//I'm injecting the dependency with through the constructor
	public ConstructorInjectedTravelService(Vehicle vehicle) {
		this.vehicle = vehicle;
		System.out.println("Using Constructor Injection");
	}

	public void startJourney() {
		vehicle.start();
	}

}


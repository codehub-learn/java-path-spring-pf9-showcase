package gr.codelearn.spring.showcase.core.service;

import gr.codelearn.spring.showcase.core.domain.Vehicle;

public class ConstructorInjectedTravelServiceImpl implements TravelService{

	//This is the dependency
	private Vehicle vehicle;

	public ConstructorInjectedTravelServiceImpl(Vehicle vehicle) {
		this.vehicle = vehicle;
		System.out.println("Using Constructor Injection");
	}

	public void startJourney() {
		vehicle.start();
	}

}


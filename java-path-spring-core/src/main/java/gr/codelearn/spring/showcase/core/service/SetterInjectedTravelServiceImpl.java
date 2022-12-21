package gr.codelearn.spring.showcase.core.service;

import gr.codelearn.spring.showcase.core.domain.Vehicle;

public class SetterInjectedTravelServiceImpl implements TravelService {

	//This is the dependency
	private Vehicle vehicle;

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
		System.out.println("Using Setter Injection");
	}

	public void startJourney() {
		vehicle.start();
	}

}

package gr.codelearn.spring.showcase.core.service;

import gr.codelearn.spring.showcase.core.domain.Vehicle;

public class AutowiredInjectedTravelService {

	//This is the dependency
	private Vehicle vehicle;

	public AutowiredInjectedTravelService() {
	}

	//To Autowire by Constructor I need to have at my class the appropriate public constructor
	public AutowiredInjectedTravelService(Vehicle vehicle) {
		this.vehicle = vehicle;
		System.out.println("Using Constructor Injection - Autowired");
	}

	//To Autowire byType or byName I need to have at my class a public setter method
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
		System.out.println("Using Setter Injection - Autowired");
	}

	public void startJourney() {
		vehicle.start();
	}
}


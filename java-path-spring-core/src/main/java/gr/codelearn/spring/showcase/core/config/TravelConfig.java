package gr.codelearn.spring.showcase.core.config;

import gr.codelearn.spring.showcase.core.domain.Vehicle;
import gr.codelearn.spring.showcase.core.service.AutowiredInjectedTravelServiceImpl;
import gr.codelearn.spring.showcase.core.service.ConstructorInjectedTravelServiceImpl;
import gr.codelearn.spring.showcase.core.service.SetterInjectedTravelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TravelConfig {

	//    Setter Injection
	@Bean(name = "bikeTravelService")
	public SetterInjectedTravelServiceImpl getSetterInjectedTravel(@Qualifier("suzukiVstrom") Vehicle vehicle) {
		SetterInjectedTravelServiceImpl setterInjectedTravel = new SetterInjectedTravelServiceImpl();
		setterInjectedTravel.setVehicle(vehicle);
		return setterInjectedTravel;
	}

	//    Constructor Injection
	@Bean(name = "carTravelService")
	public ConstructorInjectedTravelServiceImpl getConstructorInjectedTravel(@Qualifier("toyotaYaris") Vehicle vehicle) {
		return new ConstructorInjectedTravelServiceImpl(vehicle);
	}

	//	  Autowire Injection. Uses the default Object ctor and reflection to pass the dependency. Qualifier on the field
	@Bean(name = "autowiredInjectedTravel")
	public AutowiredInjectedTravelServiceImpl getAutowiredInjectedTravel() {
		return new AutowiredInjectedTravelServiceImpl();
	}
}

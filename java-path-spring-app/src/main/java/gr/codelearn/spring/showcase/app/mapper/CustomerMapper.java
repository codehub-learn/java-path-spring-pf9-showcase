package gr.codelearn.spring.showcase.app.mapper;

import gr.codelearn.spring.showcase.app.domain.Customer;
import gr.codelearn.spring.showcase.app.transfer.resource.CustomerResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends BaseMapper<Customer, CustomerResource> {
/*	@Mapping(target = "email", expression = "java(\"my@email.com\")")
	CustomerResource toResource(Customer domain);

	@Mapping(target = "email", expression = "java(\"my@email.com\")")
	List<CustomerResource> toResources(List<Customer> domains);*/
}

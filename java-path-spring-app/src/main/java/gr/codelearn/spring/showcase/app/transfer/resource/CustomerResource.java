package gr.codelearn.spring.showcase.app.transfer.resource;

import gr.codelearn.spring.showcase.app.domain.enumeration.CustomerCategory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString(callSuper = true)
public class CustomerResource extends BaseResource {
	@NotNull(message = "Customer's email cannot be null")
	private String email;

	@NotNull(message = "Customer's firstname cannot be null")
	private String firstname;

	@NotNull(message = "Customer's lastname cannot be null")
	private String lastname;

	@Min(18)
	@Max(100)
	private Integer age;

	private String address;

	@NotNull(message = "Customer's category cannot be null")
	private CustomerCategory customerCategory;
}

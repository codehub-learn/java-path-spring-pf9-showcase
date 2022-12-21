package gr.codelearn.spring.showcase.app.domain;

import gr.codelearn.spring.showcase.app.domain.enumeration.CustomerCategory;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer extends BaseModel {
	private String email;
	private String firstname;
	private String lastname;
	private Integer age;
	private String address;
	private CustomerCategory customerCategory;
}

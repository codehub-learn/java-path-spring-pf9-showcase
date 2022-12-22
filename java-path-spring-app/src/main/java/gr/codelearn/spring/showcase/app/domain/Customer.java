package gr.codelearn.spring.showcase.app.domain;

import gr.codelearn.spring.showcase.app.domain.enumeration.CustomerCategory;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "CUSTOMERS", indexes = {@Index(columnList = "email")})
@SequenceGenerator(name = "idGenerator", sequenceName = "CUSTOMERS_SEQ", initialValue = 1, allocationSize = 1)
public class Customer extends BaseModel {
	@NotNull(message = "Customer's email cannot be null")
	@Column(length = 50, nullable = false, unique = true)
	private String email;

	@NotNull(message = "Customer's firstname cannot be null")
	@Column(length = 20, nullable = false)
	private String firstname;

	@NotNull(message = "Customer's lastname cannot be null")
	@Column(length = 30, nullable = false)
	private String lastname;

	@Min(18)
	@Max(100)
	private Integer age;

	private String address;

	@NotNull(message = "Customer's category cannot be null")
	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable = false)
	private CustomerCategory customerCategory;
}

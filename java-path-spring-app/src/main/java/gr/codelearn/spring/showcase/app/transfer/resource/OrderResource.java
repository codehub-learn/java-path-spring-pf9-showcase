package gr.codelearn.spring.showcase.app.transfer.resource;

import gr.codelearn.spring.showcase.app.domain.enumeration.PaymentMethod;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString(callSuper = true)
public class OrderResource extends BaseResource {

	private CustomerResource customer;

	@NotNull
	private Date submitDate;

	@NotNull
	private PaymentMethod paymentMethod;

	@NotNull
	private BigDecimal cost;
}

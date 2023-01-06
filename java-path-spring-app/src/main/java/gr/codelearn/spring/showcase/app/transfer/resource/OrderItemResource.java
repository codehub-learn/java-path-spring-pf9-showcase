package gr.codelearn.spring.showcase.app.transfer.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@ToString(callSuper = true)
public class OrderItemResource extends BaseResource {

	private ProductResource product;

	private OrderResource order;

	@NotNull
	private Integer quantity;

	@NotNull
	private BigDecimal price;
}

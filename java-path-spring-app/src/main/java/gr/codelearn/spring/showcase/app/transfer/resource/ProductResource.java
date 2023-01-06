package gr.codelearn.spring.showcase.app.transfer.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@ToString(callSuper = true)
public class ProductResource extends BaseResource {
	@NotNull(message = "Product's serial cannot be null")
	private String serial;

	@NotNull(message = "Product's name cannot be null")
	private String name;

	@NotNull(message = "Product's price cannot be null")
	private BigDecimal price;

	@NotNull(message = "Product's category cannot be null")
	private CategoryResource category;
}

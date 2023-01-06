package gr.codelearn.spring.showcase.app.transfer.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString(callSuper = true)
public class CategoryResource extends BaseResource {
	@NotNull
	private String description;

	private String secret = "value";
}

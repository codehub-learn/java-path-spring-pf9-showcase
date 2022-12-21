package gr.codelearn.spring.showcase.app.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Product extends BaseModel {
	private String serial;
	private String name;
	private BigDecimal price;
	private Category category;
}

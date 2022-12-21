package gr.codelearn.spring.showcase.app.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Category extends BaseModel {
	private String description;
}

package gr.codelearn.spring.showcase.app.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
}

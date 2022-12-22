package gr.codelearn.spring.showcase.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PRODUCTS", indexes = {@Index(columnList = "serial")})
@SequenceGenerator(name = "idGenerator", sequenceName = "PRODUCTS_SEQ", initialValue = 1, allocationSize = 1)
public class Product extends BaseModel {
	@NotNull(message = "Product's serial cannot be null")
	@Column(length = 30, nullable = false, unique = true)
	private String serial;

	@NotNull(message = "Product's name cannot be null")
	@Column(length = 50, nullable = false)
	private String name;

	@NotNull(message = "Product's price cannot be null")
	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal price;

	@NotNull(message = "Product's category cannot be null")
	@ManyToOne
	private Category category;
}

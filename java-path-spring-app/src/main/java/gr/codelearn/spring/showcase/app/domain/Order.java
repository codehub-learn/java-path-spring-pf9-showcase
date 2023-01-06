package gr.codelearn.spring.showcase.app.domain;

import gr.codelearn.spring.showcase.app.domain.enumeration.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ORDERS", indexes = {@Index(columnList = "customer_id")})
@SequenceGenerator(name = "idGenerator", sequenceName = "ORDERS_SEQ", initialValue = 1, allocationSize = 1)
public class Order extends BaseModel {
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Customer customer;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date submitDate;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private final Set<OrderItem> orderItems = new HashSet<>();

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(length = 15, nullable = false)
	private PaymentMethod paymentMethod;

	@NotNull
	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal cost;
}

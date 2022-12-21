package gr.codelearn.spring.showcase.app.domain;

import gr.codelearn.spring.showcase.app.domain.enumeration.PaymentMethod;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class Order extends BaseModel {
	private Customer customer;
	private final Set<OrderItem> orderItems = new HashSet<>();
	private PaymentMethod paymentMethod;
	private Date submitDate;
	private BigDecimal cost;
}

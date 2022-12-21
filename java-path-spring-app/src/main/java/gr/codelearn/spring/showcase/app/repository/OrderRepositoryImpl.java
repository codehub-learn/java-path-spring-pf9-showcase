package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl extends BaseRepositoryImpl<Order> implements OrderRepository {
}

package gr.codelearn.spring.showcase.app.mapper;

import gr.codelearn.spring.showcase.app.domain.Order;
import gr.codelearn.spring.showcase.app.transfer.resource.OrderResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper extends BaseMapper<Order, OrderResource> {
}

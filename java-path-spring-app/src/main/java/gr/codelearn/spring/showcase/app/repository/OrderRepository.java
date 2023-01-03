package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.Order;
import gr.codelearn.spring.showcase.app.transfer.KeyValue;
import gr.codelearn.spring.showcase.app.transfer.PuchasesAndTotalCostPerCustomerDto;
import gr.codelearn.spring.showcase.app.transfer.PurchasesAndCostPerCustomerCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query("select o from Order o join fetch o.orderItems where o.id = ?1")
	Optional<Order> getLazy(Long id);

	@Query("select distinct o from Order o join fetch o.orderItems")
	List<Order> findAllLazy();

	@Query("select new gr.codelearn.spring.showcase.app.transfer.KeyValue(concat(c.firstname, ' ', c.lastname), " +
			"avg(o.cost)) from Order o join o.customer c group by c order by c.lastname, c.firstname")
	List<KeyValue<String, BigDecimal>> findAverageOrderCostPerCustomer();

	@Query(value = "  SELECT C.CUSTOMERCATEGORY as category, COUNT(O.*) as purchases, SUM(O.COST) as cost " +
			" FROM ORDERS O, CUSTOMERS C  WHERE O.CUSTOMER_ID = C.ID  GROUP BY C.CUSTOMERCATEGORY", nativeQuery = true)
	List<PurchasesAndCostPerCustomerCategoryDto> findTotalNumberAndCostOfPurchasesPerCustomerCategory();

	@Query(nativeQuery = true)
	List<PuchasesAndTotalCostPerCustomerDto> findTotalNumberAndTotalCostOfPurchasesPerCustomer();


}

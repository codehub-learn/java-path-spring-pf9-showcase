package gr.codelearn.spring.showcase.app.controller;

import gr.codelearn.spring.showcase.app.domain.Order;
import gr.codelearn.spring.showcase.app.mapper.BaseMapper;
import gr.codelearn.spring.showcase.app.mapper.OrderMapper;
import gr.codelearn.spring.showcase.app.service.BaseService;
import gr.codelearn.spring.showcase.app.service.OrderService;
import gr.codelearn.spring.showcase.app.transfer.ApiResponse;
import gr.codelearn.spring.showcase.app.transfer.KeyValue;
import gr.codelearn.spring.showcase.app.transfer.PurchasesAndCostPerCustomerCategoryDto;
import gr.codelearn.spring.showcase.app.transfer.resource.OrderResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController extends BaseController<Order, OrderResource> {
	private final OrderService orderService;
	private final OrderMapper orderMapper;

	@Override
	protected BaseService<Order, Long> getBaseService() {
		return orderService;
	}

	@Override
	protected BaseMapper<Order, OrderResource> getBaseMapper() {
		return orderMapper;
	}

	//	@GetMapping(headers = "action=findAverageOrderCostPerCustomer")
//	public ResponseEntity<ApiResponse<List<KeyValue<String, BigDecimal>>>> findAverageOrderCostPerCustomer() {
//		return ResponseEntity.ok(ApiResponse.<List<KeyValue<String, BigDecimal>>>builder()
//											.data(orderService.findAverageOrderCostPerCustomer()).build());
//	}

	@GetMapping(headers = "action=findTotalNumberAndCostOfPurchasesPerCustomerCategory")
	public ResponseEntity<ApiResponse<List<PurchasesAndCostPerCustomerCategoryDto>>> findTotalNumberAndCostOfPurchasesPerCustomerCategory() {
		return ResponseEntity.ok(ApiResponse.<List<PurchasesAndCostPerCustomerCategoryDto>>builder()
											.data(orderService.findTotalNumberAndCostOfPurchasesPerCustomerCategory())
											.build());
	}

	@GetMapping(path = "v1", headers = "action=findAverageOrderCostPerCustomer")
	public ResponseEntity<ApiResponse<List<KeyValue<String, BigDecimal>>>> findAverageOrderCostPerCustomerV1() {
		return ResponseEntity.ok(ApiResponse.<List<KeyValue<String, BigDecimal>>>builder()
											.data(orderService.findAverageOrderCostPerCustomer()).build());
	}

	@GetMapping(path = "v2", headers = "action=findAverageOrderCostPerCustomer")
	public ResponseEntity<ApiResponse<List<KeyValue<String, BigDecimal>>>> findAverageOrderCostPerCustomerV2() {
		return ResponseEntity.ok(ApiResponse.<List<KeyValue<String, BigDecimal>>>builder()
											.data(orderService.findAverageOrderCostPerCustomer().subList(0, 3))
											.build());
	}

	@GetMapping(headers = {"action=findAverageOrderCostPerCustomer", "api-version"})
	public ResponseEntity<ApiResponse<List<KeyValue<String, BigDecimal>>>> findAverageOrderCostPerCustomerV1V2Headers(
			@RequestHeader(value = "api-version", defaultValue = "1") Integer version) {
		if (version == 1) {
			return ResponseEntity.ok(ApiResponse.<List<KeyValue<String, BigDecimal>>>builder()
												.data(orderService.findAverageOrderCostPerCustomer()).build());
		} else if (version == 2) {
			return ResponseEntity.ok(ApiResponse.<List<KeyValue<String, BigDecimal>>>builder()
												.data(orderService.findAverageOrderCostPerCustomer().subList(0, 3))
												.build());
		}
		return ResponseEntity.ok(ApiResponse.<List<KeyValue<String, BigDecimal>>>builder()
											.data(null)
											.build());
	}

	@GetMapping(headers = "action=findAverageOrderCostPerCustomer", params = "api-version")
	public ResponseEntity<ApiResponse<List<KeyValue<String, BigDecimal>>>> findAverageOrderCostPerCustomerV1V2Params(
			@RequestParam(value = "api-version", defaultValue = "1") Integer version) {
		if (version == 1) {
			return ResponseEntity.ok(ApiResponse.<List<KeyValue<String, BigDecimal>>>builder()
												.data(orderService.findAverageOrderCostPerCustomer()).build());
		} else if (version == 2) {
			return ResponseEntity.ok(ApiResponse.<List<KeyValue<String, BigDecimal>>>builder()
												.data(orderService.findAverageOrderCostPerCustomer().subList(0, 3))
												.build());
		}
		return ResponseEntity.ok(ApiResponse.<List<KeyValue<String, BigDecimal>>>builder()
											.data(null)
											.build());
	}

	@GetMapping(headers = "action=findAverageOrderCostPerCustomer", produces = "application/vnd.app-v1+json")
	public ResponseEntity<ApiResponse<List<KeyValue<String, BigDecimal>>>> findAverageOrderCostPerCustomerV1ContentType() {
		return ResponseEntity.ok(ApiResponse.<List<KeyValue<String, BigDecimal>>>builder()
											.data(orderService.findAverageOrderCostPerCustomer()).build());
	}


}

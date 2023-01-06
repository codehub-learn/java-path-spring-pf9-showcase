package gr.codelearn.spring.showcase.app.controller;

import gr.codelearn.spring.showcase.app.configuration.AsyncTaskConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("async")
public class AsyncController {

	private static final Logger LOG = LoggerFactory.getLogger(AsyncController.class);

	@Autowired
	private AsyncTaskConfig asyncTaskConfig;

	@GetMapping("/batch")
	public ResponseEntity<String> startBatchProcessing() throws InterruptedException {
		LOG.info("Starting Batch Processing");
		asyncTaskConfig.doBatchProcessing();
		LOG.info("Batch Processing Started");
		return ResponseEntity.ok("Request to batch processing received");
	}
}

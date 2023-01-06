package gr.codelearn.spring.showcase.app.controller;

import gr.codelearn.spring.showcase.app.gateway.JokeGateway;
import gr.codelearn.spring.showcase.app.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest-template")
public class RestTemplateController {
    private final JokeGateway jokeGateway;

    @GetMapping("/jokes")
    public ResponseEntity<ApiResponse<String>> findJokes() {
        return ResponseEntity.ok(ApiResponse.<String>builder().data(jokeGateway.getJoke("single", "Programming", "Dark")).build());
    }

}

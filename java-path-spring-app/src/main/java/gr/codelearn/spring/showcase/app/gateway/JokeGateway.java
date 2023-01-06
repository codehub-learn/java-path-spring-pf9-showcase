package gr.codelearn.spring.showcase.app.gateway;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class JokeGateway {
    private final RestTemplate restTemplate;

    public String getJoke(String type, String... categories) {
        String endpoint = "https://v2.jokeapi.dev/joke/";
        URI builtEndpoint = uriBuilder(endpoint, type, categories);

        ResponseEntity<JsonNode> responseEntity = restTemplate.getForEntity(builtEndpoint, JsonNode.class);

        return responseEntity.getBody().get("joke").textValue();
    }

    private URI uriBuilder(String endpoint, String type, String... categories) {
        return UriComponentsBuilder.fromUriString(endpoint)
                .pathSegment(String.join(",", categories))
                .queryParam("type", type)
                .build()
                .toUri();
    }
}

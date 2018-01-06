package pl.kobietydokodu.bilet;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WebappApplicationIT {
    
    @Autowired
    private TestRestTemplate restTemplate;
    
	@Test
	public void contextLoads() {
	    ResponseEntity<ObjectNode> response = this.restTemplate.getForEntity("/health", ObjectNode.class);
	    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	    
	    ObjectNode body = response.getBody();
        assertThat(body).isNotNull().isNotEmpty();
	    
        JsonNode healthStatus = body.get("status");
        assertThat(healthStatus).isInstanceOf(TextNode.class);
	    assertThat(healthStatus.asText()).isEqualTo("UP");
	}
}

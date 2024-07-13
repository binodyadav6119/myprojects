package com.deals.deals;

import com.deals.deals.model.Deals;
import com.deals.deals.repository.DealRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DealsApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private DealRepository dealRepository;

	@Test
	void testCreateDeal() {
		String url = "http://localhost:" + port + "/api/deals/createDeal";
		Deals deal = new Deals(null, "Test Item", 100.0, 10, 0, null, LocalDateTime.now().plusHours(2), true);
		HttpEntity<Deals> request = new HttpEntity<>(deal);

		ResponseEntity<Deals> response = restTemplate.postForEntity(url, request, Deals.class);
		System.out.println(response.getStatusCodeValue());
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		assertThat(response.getBody().getItemName()).isEqualTo("Test Item");
	}

}

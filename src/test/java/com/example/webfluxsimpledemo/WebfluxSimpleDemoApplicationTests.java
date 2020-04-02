package com.example.webfluxsimpledemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.scheduler.Schedulers;

class WebfluxSimpleDemoApplicationTests {

	@Test
	void contextLoads() {

		/*WebClient webClient = WebClient.create("http://localhost:8080");
    webClient
        .get()
        .uri("/numbers")
        .retrieve()
        .bodyToFlux(Integer.class)
        .log()
        .subscribeOn(Schedulers.single())
				.collectList()
				.block();*/
	}

}

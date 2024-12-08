package com.twitter.Twitter.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class TwitterService {

    private final WebClient webClient;

    @Value("${twitter.api.base-url}")
    private String baseUrl;

    @Value("${twitter.api.bearer-token}")
    private String bearerToken;

    public TwitterService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> fetchTweets(String query) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/tweets/search/recent")
                        .queryParam("query", query)
                        .build())
                .header("Authorization", bearerToken)
                .retrieve()
                .bodyToMono(String.class);
    }
}

package com.phrase.demo.restclients.utils;

import org.springframework.web.reactive.function.client.WebClient;

public class WebClientUtils {

    public static WebClient getWebClient(String apiBaseURL) {
        return WebClient.builder()
                .baseUrl(apiBaseURL)
                .build();
    }
}

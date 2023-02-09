package com.phrase.demo.restclients;

import com.phrase.demo.models.Credentials;
import com.phrase.demo.models.UserAuth;
import com.phrase.demo.restclients.utils.WebClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class LoginClientPhraseImpl implements LoginClient {

    Logger LOG = LoggerFactory.getLogger(LoginClientPhraseImpl.class);

    @Value("${rest.api.phrase.base.url}")
    private String API_BASE_URL;

    private final String LOGIN_API_ENDPOINT = "auth/login";

    @Override
    public UserAuth findByCredentials(Credentials credentials) {

        LOG.info("Calling web client POST {}{}", API_BASE_URL, LOGIN_API_ENDPOINT);

        return WebClientUtils.getWebClient(API_BASE_URL).post()
                .uri(LOGIN_API_ENDPOINT)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(credentials), Credentials.class)
                .retrieve()
                .bodyToMono(UserAuth.class)
                .block();
    }
}

package com.phrase.demo.controllers;

import com.phrase.demo.models.CredentialsDto;
import com.phrase.demo.models.UserAuth;
import com.phrase.demo.services.LoginService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/auth")
public class LoginController {

    Logger LOG = LoggerFactory.getLogger(LoginController.class);

    LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping( value = "/login",
            consumes = { MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<UserAuth> authenticateUser(@Valid @RequestBody CredentialsDto credentialsDto) {
        LOG.info("Endpoint /api/v1/auth/login called with credentials: {}", credentialsDto);

        try {
            UserAuth userAuth = loginService.authenticateUser(credentialsDto.toCredentials());

            return new ResponseEntity<>(userAuth, HttpStatus.OK);
        } catch (WebClientResponseException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getStatusText(), e);
        }
    }
}

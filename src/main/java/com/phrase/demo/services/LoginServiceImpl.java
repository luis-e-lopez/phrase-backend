package com.phrase.demo.services;

import com.phrase.demo.models.Credentials;
import com.phrase.demo.models.UserAuth;
import com.phrase.demo.restclients.LoginRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private final LoginRestClient loginRestClient;
    private final CredentialsService credentialsService;

    @Autowired
    public LoginServiceImpl(LoginRestClient loginRestClient, CredentialsService credentialsService) {
        this.loginRestClient = loginRestClient;
        this.credentialsService = credentialsService;
    }

    @Override
    public UserAuth authenticateUser(Credentials credentials) {
        UserAuth userAuth = loginRestClient.getByCredentials(credentials);
        if (userAuth != null)
            credentialsService.save(credentials);

        return userAuth;
    }
}

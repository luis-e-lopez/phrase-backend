package com.phrase.demo.services;

import com.phrase.demo.models.Credentials;
import com.phrase.demo.models.UserAuth;
import com.phrase.demo.restclients.LoginClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private final LoginClient loginClient;
    private final CredentialsService credentialsService;

    @Autowired
    public LoginServiceImpl(LoginClient loginClient, CredentialsService credentialsService) {
        this.loginClient = loginClient;
        this.credentialsService = credentialsService;
    }

    @Override
    public UserAuth authenticateUser(Credentials credentials) {
        UserAuth userAuth = loginClient.findByCredentials(credentials);
        if (userAuth != null)
            credentialsService.save(credentials);

        return userAuth;
    }
}

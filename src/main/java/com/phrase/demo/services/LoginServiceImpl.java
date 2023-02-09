package com.phrase.demo.services;

import com.phrase.demo.models.Credentials;
import com.phrase.demo.models.UserAuth;
import com.phrase.demo.restclients.LoginClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    LoginClient loginClient;

    @Autowired
    public LoginServiceImpl(LoginClient loginClient) {
        this.loginClient = loginClient;
    }

    @Override
    public UserAuth authenticateUser(Credentials credentials) {
        return loginClient.findByCredentials(credentials);
    }
}

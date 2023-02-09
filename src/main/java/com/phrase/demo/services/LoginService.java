package com.phrase.demo.services;

import com.phrase.demo.models.Credentials;
import com.phrase.demo.models.UserAuth;

public interface LoginService {
    UserAuth authenticateUser(Credentials credentials);
}

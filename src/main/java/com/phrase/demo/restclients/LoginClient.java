package com.phrase.demo.restclients;

import com.phrase.demo.models.Credentials;
import com.phrase.demo.models.UserAuth;

public interface LoginClient {
    UserAuth findByCredentials(Credentials credentials);
}

package com.phrase.demo.restclients;

import com.phrase.demo.models.Credentials;
import com.phrase.demo.models.UserAuth;

public interface LoginRestClient {
    UserAuth getByCredentials(Credentials credentials);
}

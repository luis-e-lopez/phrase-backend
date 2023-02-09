package com.phrase.demo.services;

import com.phrase.demo.models.Credentials;
import com.phrase.demo.repositories.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredentialsServiceImpl implements CredentialsService {

    private final CredentialsRepository repository;

    @Autowired
    public CredentialsServiceImpl(CredentialsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Credentials save(Credentials credentials) {
        return repository.save(credentials);
    }
}

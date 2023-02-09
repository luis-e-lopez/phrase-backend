package com.phrase.demo.services;

import com.phrase.demo.models.Projects;

public interface ProjectsService {
    Projects findAll(String token);
}

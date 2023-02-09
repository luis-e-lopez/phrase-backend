package com.phrase.demo.restclients;

import com.phrase.demo.models.Projects;

public interface ProjectsClient {
    Projects findAll(String token);
}

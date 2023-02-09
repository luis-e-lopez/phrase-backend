package com.phrase.demo.restclients;

import com.phrase.demo.models.Projects;

public interface ProjectsRestClient {
    Projects getAll(String token);
}

package com.phrase.demo.services;

import com.phrase.demo.models.Projects;
import com.phrase.demo.restclients.ProjectsRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectsServiceImpl implements ProjectsService {

    private final ProjectsRestClient projectsRestClient;

    @Autowired
    public ProjectsServiceImpl(ProjectsRestClient projectsRestClient) {
        this.projectsRestClient = projectsRestClient;
    }

    @Override
    public Projects findAll(String token) {
        return projectsRestClient.getAll(token);
    }
}

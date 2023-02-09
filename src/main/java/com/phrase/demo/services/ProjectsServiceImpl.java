package com.phrase.demo.services;

import com.phrase.demo.models.Projects;
import com.phrase.demo.restclients.ProjectsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectsServiceImpl implements ProjectsService {

    ProjectsClient projectsClient;

    @Autowired
    public ProjectsServiceImpl(ProjectsClient projectsClient) {
        this.projectsClient = projectsClient;
    }

    @Override
    public Projects findAll(String token) {
        return projectsClient.findAll(token);
    }
}

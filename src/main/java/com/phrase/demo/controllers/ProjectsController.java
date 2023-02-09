package com.phrase.demo.controllers;

import com.phrase.demo.models.Projects;
import com.phrase.demo.services.ProjectsService;
import jakarta.validation.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;

@Validated
@RestController
@RequestMapping("/api/v1/projects")
public class ProjectsController {

    Logger LOG = LoggerFactory.getLogger(ProjectsController.class);

    private final ProjectsService projectsService;

    @Autowired
    public ProjectsController(ProjectsService projectsService) {
        this.projectsService = projectsService;
    }

    @GetMapping(value = "/{token}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Projects> list(@NotEmpty @PathVariable("token") String token) {
        LOG.info("Endpoint /api/v1/projects/{token} called with token: {}", token);

        try {
            Projects projects = projectsService.findAll(token);

            return new ResponseEntity<>(projects, HttpStatus.OK);
        } catch (WebClientResponseException e) {
            if (e.getStatusCode() == HttpStatus.UNAUTHORIZED)
                throw new ResponseStatusException(e.getStatusCode(), "Unauthorized or token expired", e);
            if (e.getStatusCode().is4xxClientError())
                throw new ResponseStatusException(e.getStatusCode(), e.getStatusText(), e);
            throw new ResponseStatusException(e.getStatusCode(), e.getStatusText(), e);
        }
    }
}

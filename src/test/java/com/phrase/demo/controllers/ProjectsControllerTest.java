package com.phrase.demo.controllers;

import com.phrase.demo.models.Project;
import com.phrase.demo.models.Projects;
import com.phrase.demo.services.ProjectsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(controllers = ProjectsController.class)
public class ProjectsControllerTest {

    @MockBean
    private ProjectsService projectsService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetListOfProjects() throws Exception {
        String token = "xiuhs83kmsi983nc83j83nc8iojdco95";
        List<Project> list = List.of(
                new Project("proj1", "NEW", "es", List.of("en", "cz")),
                new Project("proj2", "NEW", "en", List.of("es"))
        );
        Projects projects = new Projects(2, list);

        when(projectsService.findAll(token)).thenReturn(projects);

        mockMvc.perform(get("/api/v1/projects/" + token)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.projects", hasSize(2)));
    }

    @Test
    public void testExpiredToken() throws Exception {
        String token = "xiuhs83kmsi983nc83j83nc8iojdco95";

        when(projectsService.findAll(token)).thenThrow(new WebClientResponseException(401, "Unauthorized", null, null, null));;

        mockMvc.perform(get("/api/v1/projects/" + token)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isUnauthorized());
    }

}

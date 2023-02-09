package com.phrase.demo.restclients;

import com.phrase.demo.models.CommonResponse;
import com.phrase.demo.models.Project;
import com.phrase.demo.models.Projects;
import com.phrase.demo.restclients.utils.WebClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class ProjectsClientPhraseImpl implements ProjectsClient {

    Logger LOG = LoggerFactory.getLogger(ProjectsClientPhraseImpl.class);

    @Value("${rest.api.phrase.base.url}")
    private String API_BASE_URL;
    private final String PROJECTS_API_ENDPOINT = "projects";

    @Override
    public Projects findAll(String token) {

        LOG.info("Calling web client GET {}{}", API_BASE_URL, PROJECTS_API_ENDPOINT);

        CommonResponse<Project> res = WebClientUtils.getWebClient(API_BASE_URL).get()
                .uri(PROJECTS_API_ENDPOINT)
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", "ApiToken " + token)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<CommonResponse<Project>>() {})
                .block();

        return new Projects(res.getTotalElements(), res.getContent());
    }
}

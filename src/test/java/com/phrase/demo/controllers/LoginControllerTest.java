package com.phrase.demo.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.phrase.demo.models.CredentialsDto;
import com.phrase.demo.models.User;
import com.phrase.demo.models.UserAuth;
import com.phrase.demo.services.LoginService;
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

import static org.hamcrest.Matchers.comparesEqualTo;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(controllers = LoginController.class)
public class LoginControllerTest {

    @MockBean
    private LoginService loginService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSuccessfulLogin() throws Exception {
        CredentialsDto credentialsDto = new CredentialsDto("user1", "pass1");
        User user = new User("John", "Doe");

        when(loginService.authenticateUser(any())).thenReturn(new UserAuth(user, "123456789"));

        mockMvc.perform(post("/api/v1/auth/login")
                .content(asJsonString(credentialsDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.token", comparesEqualTo("123456789")));
    }

    @Test
    public void testUnauthorizedLogin() throws Exception {
        CredentialsDto credentialsDto = new CredentialsDto("user1", "pass1");

        when(loginService.authenticateUser(any())).thenThrow(new WebClientResponseException(401, "Unauthorized", null, null, null));

        mockMvc.perform(post("/api/v1/auth/login")
                .content(asJsonString(credentialsDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isUnauthorized());
    }

    private static String asJsonString(final Object obj) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(obj);
    }
}

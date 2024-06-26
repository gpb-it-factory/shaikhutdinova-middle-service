package com.middleservice.presentation;


import com.middleservice.UserApiConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
@AutoConfigureMockMvc
public class TestUserController extends ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Проверка успешного создания пользователя")
    void shouldCreateUserSuccessfully() throws Exception {
        var createUserRequest = post("/api/v2/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                          "userId": 1,
                          "userName": "Joe"
                        }
                        """);

        mockMvc.perform(createUserRequest)
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Проверка, что при создании существующего пользователя возвращается статус 409")
    void shouldReturnStatus409WhenUserAlreadyExists() throws Exception {
        var createUserRequest = post("/api/v2/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "userId": 1,
                            "userName": "Joe"
                        }
                        """);


        mockMvc.perform(createUserRequest)
                .andDo(print())
                .andExpect(status().isCreated());

        mockMvc.perform(createUserRequest)
                .andDo(print())
                .andExpect(status().isConflict());
    }
}
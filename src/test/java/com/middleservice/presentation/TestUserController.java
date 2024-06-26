package com.middleservice.presentation;

import com.middleservice.MiddleServiceApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class TestUserController extends ControllerTest {


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


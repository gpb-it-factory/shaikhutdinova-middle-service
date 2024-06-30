package com.middleservice.presentation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
                            "userId": 2,
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

    @Test
    @DisplayName("Проверка успешного создания счета")
    void shouldCreateAccountSuccessfully() throws Exception {
        var createUserRequest = post("/api/v2/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "userId": 3,
                            "userName": "Anna"
                        }
                        """);

        mockMvc.perform(createUserRequest)
                .andDo(print())
                .andExpect(status().isCreated());

        var createAccountRequest = post("/api/v2/users/3/accounts")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(createAccountRequest)
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Проверка, что при создании существующего счета возвращается статус 409")
    void shouldReturnStatus409WhenAccountAlreadyExists() throws Exception {
        var createUserRequest = post("/api/v2/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "userId": 4,
                            "userName": "Bob"
                        }
                        """);

        mockMvc.perform(createUserRequest)
                .andDo(print())
                .andExpect(status().isCreated());

        var createAccountRequest = post("/api/v2/users/4/accounts")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(createAccountRequest)
                .andDo(print())
                .andExpect(status().isCreated());

        mockMvc.perform(createAccountRequest)
                .andDo(print())
                .andExpect(status().isConflict());
    }


    @Test
    @DisplayName("Проверка, что при создании счета для несуществующего пользователя возвращается статус 404")
    void shouldReturnStatus404WhenUserNotFound() throws Exception {
        var createAccountRequest = post("/api/v2/users/999/accounts")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(createAccountRequest)
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Проверка успешного получения баланса")
    void shouldGetCurrentBalanceSuccessfully() throws Exception {
        // Сначала создадим пользователя
        var createUserRequest = post("/api/v2/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "userId": 5,
                            "userName": "Eve"
                        }
                        """);

        mockMvc.perform(createUserRequest)
                .andDo(print())
                .andExpect(status().isCreated());

        // Затем создадим счет для этого пользователя
        var createAccountRequest = post("/api/v2/users/5/accounts")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(createAccountRequest)
                .andDo(print())
                .andExpect(status().isCreated());

        // Теперь запросим баланс счета
        var getCurrentBalanceRequest = get("/api/v2/users/5/accounts")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(getCurrentBalanceRequest)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accountId").value(5))
                .andExpect(jsonPath("$.accountName").value("Акционный"))
                .andExpect(jsonPath("$.balance").value(5000.0));
    }

    @Test
    @DisplayName("Проверка успешного перевода средств")
    void shouldTransferFundsSuccessfully() throws Exception {
        // Создаем отправителя
        mockMvc.perform(post("/api/v2/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "userId": 456,
                                  "userName": "sender"
                                }
                                """))
                .andDo(print())
                .andExpect(status().isCreated());

        // Создаем получателя
        mockMvc.perform(post("/api/v2/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "userId": 457,
                                  "userName": "receiver"
                                }
                                """))
                .andDo(print())
                .andExpect(status().isCreated());

        // Создаем счет для отправителя
        mockMvc.perform(post("/api/v2/users/456/accounts")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());

        // Создаем счет для получателя
        mockMvc.perform(post("/api/v2/users/457/accounts")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());

        // Переводим средства
        mockMvc.perform(post("/api/v2/transfers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "from": "sender",
                                  "to": "receiver",
                                  "amount": "1000.00"
                                }
                                """))
                .andDo(print())
                .andExpect(status().isOk());
    }
}



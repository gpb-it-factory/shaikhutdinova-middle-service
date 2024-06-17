
import com.middleservice.MiddleServiceApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = MiddleServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TestUserController extends ControllerTest {


    @Test
    void whenPassToRequestBodyValidTelegramUserId_thenReturnStatus204() throws Exception {
        var createUserRequest = post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {"userId":1,
                        "userName":"Joe"}
                        """);

        mockMvc.perform(createUserRequest)
                .andDo(print())
                .andExpect(status().isNoContent());


    }


    @Test
    void whenUserAlreadyExists_thenReturnStatus409() throws Exception {
        var createUserRequest = post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "userId": 1,
                            "userName": "Joe"
                        }
                        """);


        // Try to create the same user again
        mockMvc.perform(createUserRequest)
                .andDo(print())
                .andExpect(status().isConflict());
    }
}


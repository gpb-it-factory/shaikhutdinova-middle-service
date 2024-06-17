
import com.middleservice.MiddleServiceApplication;
import com.middleservice.application.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest (classes = MiddleServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TestUserController extends ControllerTest {



    @Test
    void whenPassToRequestBodyValidTelegramUserId_thenReturnStatus204() throws Exception {
        var createUserRequest = post("api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {"userId":1,
                        "userName":"Joe"}
                        """);

        mockMvc.perform(createUserRequest)
                .andDo(print())
                .andExpect(status().isNoContent());


    }
}


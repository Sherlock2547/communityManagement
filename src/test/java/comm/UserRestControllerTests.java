package comm;

import community.CommunityManagementApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by 17206133--周文林
 * Date: 2020/5/5 18:41 下午
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommunityManagementApp.class)
@AutoConfigureMockMvc
public class UserRestControllerTests {
    @Autowired
    private MockMvc mockMvc;	//mockito,spring-test

    @Test
    public void test() throws Exception{
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.content", containsString("17206133-周文林"))) //jsonpath
                .andReturn();

    }


}

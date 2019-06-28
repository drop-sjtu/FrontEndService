package org.dropsjtu.login;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class LoginApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() {
    }

    @Test
    public void loginSuccessThenReturnToken() throws Exception {
        MvcResult result = this.mockMvc.perform(post("/login")
                .param("username", "SE418")
                .param("password", "SE418"))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(content);
        int code = jsonObject.getInt("code");
        assertEquals(0, code);
    }

    @Test
    public void loginFailedThenReturn401() throws Exception {
        MvcResult result = this.mockMvc.perform(post("/login")
                .param("username", "incorrect")
                .param("password", "incorrect"))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(content);
        int code = jsonObject.getInt("code");
        assertEquals(1, code);
    }
}

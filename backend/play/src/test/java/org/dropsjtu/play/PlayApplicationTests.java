package org.dropsjtu.play;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class PlayApplicationTests {

    @Autowired
    private WordLadderController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void accessWordLadderThenOk() throws Exception {
        this.mockMvc.perform(get("/wordladders")
                .param("from", "hello")
                .param("to", "world")
                .param("token", "3535ce20-1b02-41fe-8e8b-e4ac5ab8d7c7"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'status':0}"));
    }

    @Test
    public void shouldHaveNoLadderStatus() throws Exception {
        this.mockMvc.perform(get("/wordladders")
                .param("from", "successful")
                .param("to", "fail")
                .param("token", "3535ce20-1b02-41fe-8e8b-e4ac5ab8d7c7"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'status':-1}"));
    }

    @Test
    public void accessWithoutParameters() throws Exception {
        this.mockMvc.perform(get("/wordladders")
                .param("token", "3535ce20-1b02-41fe-8e8b-e4ac5ab8d7c7"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'status':-3}"));
    }

    @Test
    public void tokenNotRight() throws Exception {
        this.mockMvc.perform(get("/wordladders")
                .param("from", "hello")
                .param("to", "world")
                .param("token", "1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'status':-4}"));
    }
}

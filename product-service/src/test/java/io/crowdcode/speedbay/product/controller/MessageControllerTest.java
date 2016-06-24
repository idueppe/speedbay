package io.crowdcode.speedbay.product.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.crowdcode.speedbay.product.MessageEndpoint;
import io.crowdcode.speedbay.product.ProductSpringApplication;
import io.crowdcode.speedbay.product.model.Message;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ProductSpringApplication.class)
@WebAppConfiguration
public class MessageControllerTest {

    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;


    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testGetMessages() throws Exception {
        mockMvc.perform(get("/messages"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.[0].author","ingo").exists());
    }

    @Test
    public void testGetSpecificMessages() throws Exception {
        mockMvc.perform(get(MessageEndpoint.MESSAGES_MESSAGE_ID,1l))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.[0].author","ingo").exists());
    }


    @Test
    public void testCreateMessage() throws Exception {
        mockMvc.perform(post("/messages")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(asJsonString(new Message().withAuthor("ich").withText("du"))))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void testJsonString() throws Exception {
        asJsonString(new Message().withAuthor("ich").withText("du"));
    }

    private String asJsonString(Object value) throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(value);
        System.out.println(json);
        return json;
    }
}
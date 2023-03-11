package com.example.BookStore.Controller;

import com.example.BookStore.Model.Publisher;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PublisherController.class)
public class PublisherControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PublisherController Repo;
    private ObjectMapper mapper = new ObjectMapper();
    String input;
    Publisher publisher;
    @Before
    public void setUp() throws Exception{
        publisher = new Publisher();
        publisher.setCity("Printing City");
        publisher.setState("UH");
        publisher.setEmail("Colins@publisher.com");
        publisher.setName("Colins");
        publisher.setPhone("8795923");
        publisher.setStreet("Publishing Street");
        publisher.setPostal_code("523942");
        input = mapper.writeValueAsString(publisher);


    }
    @Test
    public void shouldCreateBook() throws Exception {
        mockMvc.perform(post("/publisher")
                        .content(input)
                        .contentType(MediaType.APPLICATION_JSON)

                )
                .andDo(print())
                .andExpect(status().isCreated());


    }

    @Test
    public void shouldReadById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/publisher/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldReadAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/publisher")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void deletePublisherById() throws Exception {
        mockMvc.perform(delete("/publisher/1")).andDo(print()).andExpect(status().isNoContent());
    }

}
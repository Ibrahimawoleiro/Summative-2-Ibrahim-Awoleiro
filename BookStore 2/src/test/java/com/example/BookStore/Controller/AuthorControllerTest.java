package com.example.BookStore.Controller;


import com.example.BookStore.Model.Author;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorController.class)
public class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AuthorController Repo;
    Author authorTest;
    String input;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
        authorTest = new Author();
        authorTest.setAuthor_id(1);
        authorTest.setCity("limo City");
        authorTest.setState("CA");
        authorTest.setFirst_name("Kimo");
        authorTest.setLast_name("zing");
        authorTest.setPhone("25355234");
        authorTest.setEmail("kimozing@gmail.com");
        authorTest.setPostal_code("124233");
        authorTest.setStreet("Writer Street");
        input = mapper.writeValueAsString(authorTest);
    }

    @Test
    public void shouldCreateAuthor() throws Exception {
        mockMvc.perform(post("/author")
                        .content(input)
                        .contentType(MediaType.APPLICATION_JSON)

                )
                .andDo(print())
                .andExpect(status().isCreated());


    }


    @Test
    public void shouldReadById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/author/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldReadAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/author")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void deleteByid() throws Exception {
        mockMvc.perform(delete("/author/1")).andDo(print()).andExpect(status().isNoContent());
    }

    @Test
    public void Updateauthor() throws Exception {
        authorTest.setLast_name("thing");
        authorTest.setPhone("98685409");
        input = mapper.writeValueAsString(authorTest);

        mockMvc.perform(
                        put("/author")
                                .content(input)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }
}

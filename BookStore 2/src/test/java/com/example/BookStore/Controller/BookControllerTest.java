package com.example.BookStore.Controller;

import com.example.BookStore.Model.Author;
import com.example.BookStore.Model.Book;
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

import java.math.BigDecimal;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorController.class)
public class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BookController Repo;
    @MockBean
    AuthorController Rep;
    @MockBean
    PublisherController Re;


    Book book;
    Author author;
    Publisher publisher;

    private ObjectMapper mapper = new ObjectMapper();
    String input;
    @Before
    public void setUp() throws Exception{

        author= new Author();
        author.setCity("limo City");
        author.setState("CA");
        author.setFirst_name("Kimo");
        author.setLast_name("zing");
        author.setPhone("25355234");
        author.setEmail("kimozing@gmail.com");
        author.setPostal_code("124233");
        author.setStreet("Writer Street");

        publisher = new Publisher();
        publisher.setCity("Printing City");
        publisher.setState("UH");
        publisher.setEmail("Colins@publisher.com");
        publisher.setName("Colins");
        publisher.setPhone("8795923");
        publisher.setStreet("Publishing Street");
        publisher.setPostal_code("523942");


        book = new Book();
        book.setIsbn("2345324");
        book.setAuthor_id(author.getAuthor_id());
        Date date = new Date();
        book.setPublish_date(date);
        book.setTitle("Running down the Hill");
        book.setPrice(BigDecimal.valueOf(56));
        book.setPublisher_id(publisher.getPublisher_id());
        input = mapper.writeValueAsString(book);
    }

    @Test
    public void shouldCreateBook() throws Exception {
        mockMvc.perform(post("/Book")
                        .content(input)
                        .contentType(MediaType.APPLICATION_JSON)

                )
                .andDo(print())
                .andExpect(status().isCreated());


    }

    @Test
    public void shouldReadById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/Book/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldReadAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/Book")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void deleteByid() throws Exception {
        mockMvc.perform(delete("/Book/1")).andDo(print()).andExpect(status().isNoContent());
    }

    public void deleteByauthorsid() throws Exception {
        mockMvc.perform(delete("/Book/author/1")).andDo(print()).andExpect(status().isNoContent());
    }

}
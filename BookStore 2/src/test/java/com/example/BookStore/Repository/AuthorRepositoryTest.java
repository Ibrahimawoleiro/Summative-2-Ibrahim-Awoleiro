package com.example.BookStore.Repository;

import com.example.BookStore.Model.Author;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthorRepositoryTest {

    @Autowired
    AuthorRepository AuthorRepo;

    Author author;


    @Before
    public void setUp() throws Exception{
        AuthorRepo.deleteAll();
        author= new Author();
        author.setCity("limo City");
        author.setState("CA");
        author.setFirst_name("Kimo");
        author.setLast_name("zing");
        author.setPhone("25355234");
        author.setEmail("kimozing@gmail.com");
        author.setPostal_code("124233");
        author.setStreet("Writer Street");
        author=AuthorRepo.save(author);

    }
    @Test
    public void shouldAddAuthor(){
        Author author1 = new Author();
        author1.setCity("bimbim");
        author1.setState("YT");
        author1.setFirst_name("Tom");
        author1.setLast_name("Robin");
        author1.setPhone("47463433");
        author1.setEmail("kimozing@gmail.com");
        author1.setPostal_code("18893");
        author1.setStreet("Youtube Street");
        author1=AuthorRepo.save(author1);
        Optional<Author> authorHolder = AuthorRepo.findById(author1.getAuthor_id());
        assertEquals(authorHolder.get().getAuthor_id(),author1.getAuthor_id());
    }

    @Test
    public void shouldUpdateAuthor() throws Exception{
        author.setPhone("2356937");
        author.setLast_name("Duro");
        AuthorRepo.save(author);
        Optional<Author> authorTestHolder = AuthorRepo.findById(author.getAuthor_id());
        assertEquals(authorTestHolder.get().getState(),author.getState());
    }

    @Test
    public void shouldfindById() throws Exception{
        Optional<Author> authorTestHolder = AuthorRepo.findById(author.getAuthor_id());
        assertEquals(authorTestHolder.get().getAuthor_id(),author.getAuthor_id());
    }
    @Test
    public void shouldReadAll() throws Exception{
        List<Author> authorList = AuthorRepo.findAll();
        assertEquals(authorList.size(), AuthorRepo.count());
    }

    @Test
    public void shouldDeleteCustomer() throws Exception{
        AuthorRepo.deleteById(author.getAuthor_id());
        Optional<Author> customer2 = AuthorRepo.findById(author.getAuthor_id());
        assertFalse(customer2.isPresent());
    }

}
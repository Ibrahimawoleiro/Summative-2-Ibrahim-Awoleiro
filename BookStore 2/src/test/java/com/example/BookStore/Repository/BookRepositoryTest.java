package com.example.BookStore.Repository;

import com.example.BookStore.Model.Author;
import com.example.BookStore.Model.Book;
import com.example.BookStore.Model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BookRepositoryTest {
    @Autowired
    BookRepository BookRepo;
    @Autowired
    AuthorRepository AuthorRepo;
    @Autowired
    PublisherRepository PublisherRepo;
    Book book;
    Author author;
    Publisher publisher;
    @Before
    public void setUp() throws Exception{
        BookRepo.deleteAll();
        AuthorRepo.deleteAll();
        PublisherRepo.deleteAll();

        author= new Author();
        author.setCity("limo City");
        author.setState("CA");
        author.setFirst_name("Kimo");
        author.setLast_name("zing");
        author.setPhone("25355234");
        author.setEmail("kimozing@gmail.com");
        author.setPostal_code("124233");
        author.setStreet("Writer Street");
        AuthorRepo.save(author);
        System.out.println(AuthorRepo.count());

        publisher=new Publisher();
        publisher.setCity("Printing City");
        publisher.setState("UH");
        publisher.setEmail("Colins@publisher.com");
        publisher.setName("Colins");
        publisher.setPhone("8795923");
        publisher.setStreet("Publishing Street");
        publisher.setPostal_code("523942");
        PublisherRepo.save(publisher);


        book = new Book();
        book.setIsbn("2345324");
        book.setAuthor_id(author.getAuthor_id());
        Date date = new Date();
        book.setPublish_date(date);
        book.setTitle("Running down the Hill");
        book.setPrice(BigDecimal.valueOf(56));
        book.setPublisher_id(publisher.getPublisher_id());
        BookRepo.save(book);
    }

    @Test
    public void shouldCreateBook() throws Exception{
        Book book1 = new Book();
        book1 = new Book();
        book1.setIsbn("237838");
        book1.setAuthor_id(author.getAuthor_id());
        Date date = new Date();
        book1.setPublish_date(date);
        book1.setTitle("Reach for the Stars");
        book1.setPrice(BigDecimal.valueOf(89));
        book1.setPublisher_id(publisher.getPublisher_id());
        book1=BookRepo.save(book1);
        Optional<Book> BookTestHolder = BookRepo.findById(book1.getBook_id());
        assertEquals(BookTestHolder.get().getAuthor_id(),book1.getAuthor_id());
    }

    @Test
    public void shouldUpdateBook() throws Exception{
        book.setPrice(BigDecimal.valueOf(43));
        book.setTitle("Balacing on the edge of a needle");
        book=BookRepo.save(book);
        Optional<Book> BookHolder= BookRepo.findById(book.getBook_id());
        assertEquals(BookHolder.get().getTitle(),book.getTitle(),"Balacing on the edge of a needle");
    }

    @Test
    public void shouldfindById() throws Exception{
        Optional<Book> authorTestHolder = BookRepo.findById(book.getBook_id());
        assertEquals(authorTestHolder.get().getBook_id(),book.getBook_id());
    }

    @Test
    public void shouldReadAll() throws Exception{
        List<Book> authorList = BookRepo.findAll();
        assertEquals(authorList.size(), BookRepo.count());
    }

    @Test
    public void shouldDeleteCustomer() throws Exception{
        BookRepo.deleteById(book.getBook_id());
        Optional<Book> bookHolder = BookRepo.findById(book.getBook_id());
        assertFalse(bookHolder.isPresent());
    }

    @Test
    public void shouldSearchByAuthorsId() throws Exception{
        List<Book> BookHolder=BookRepo.findByauthor(book.getAuthor_id());
        assertEquals(BookHolder.get(0).getAuthor_id(),book.getAuthor_id());
    }
}
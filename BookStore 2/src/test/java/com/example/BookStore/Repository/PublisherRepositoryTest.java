package com.example.BookStore.Repository;

import com.example.BookStore.Model.Publisher;
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
public class PublisherRepositoryTest {
    @Autowired
    PublisherRepository PublisherRepo;

    Publisher publisher2;

    @Before
    public void setUp() throws Exception{
        PublisherRepo.deleteAll();
        publisher2=new Publisher();
        publisher2.setCity("Tired City");
        publisher2.setEmail("John@Blabla.com");
        publisher2.setPhone("345634534");
        publisher2.setStreet("Exhausted Street");
        publisher2.setPostal_code("8979");
        publisher2.setName("John");
        publisher2.setState("YT");
        publisher2=PublisherRepo.save(publisher2);
    }

    //Creating a publisher
    @Test
    public void shouldCreateAPublisher() throws Exception{
        Publisher publisher = new Publisher();
        publisher.setCity("Sleepy City");
        publisher.setEmail("Jake@Blabla.com");
        publisher.setPhone("84793939");
        publisher.setStreet("Sleep Walking Street");
        publisher.setPostal_code("6732");
        publisher.setName("Jake");
        publisher.setState("HO");
        PublisherRepo.save(publisher);
        Optional<Publisher> publisherHolder = PublisherRepo.findById(publisher.getPublisher_id());
        assertEquals(publisher.getPublisher_id(),publisherHolder.get().getPublisher_id());
    }

    //Updating publisher
    @Test
    public void shouldUpdatePublisher() throws Exception{
        PublisherRepo.save(publisher2);
        publisher2.setName("Blake");
        PublisherRepo.save(publisher2);
        Optional<Publisher> publisherHolder = PublisherRepo.findById(publisher2.getPublisher_id());
        assertEquals(publisherHolder.get().getName(), publisher2.getName());

    }

    @Test
    public void shouldGetAllPublishers() throws Exception{
        List<Publisher> publisherList = PublisherRepo.findAll();
        assertEquals(publisherList.size(),PublisherRepo.count());
    }

    @Test
    public void shouldGetById(){
        Optional<Publisher> publisherHolder = PublisherRepo.findById(publisher2.getPublisher_id());
        assertEquals(publisher2.getPublisher_id(), publisherHolder.get().getPublisher_id());
    }

    @Test
    public void shouldDeleteById(){
        PublisherRepo.deleteById(publisher2.getPublisher_id());
        Optional<Publisher> publisherHolder = PublisherRepo.findById(publisher2.getPublisher_id());
        assertFalse(publisherHolder.isPresent());
    }
}
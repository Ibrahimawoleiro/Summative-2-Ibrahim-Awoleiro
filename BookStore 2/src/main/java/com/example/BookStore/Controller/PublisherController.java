package com.example.BookStore.Controller;

import com.example.BookStore.Model.Publisher;
import com.example.BookStore.Repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PublisherController {
    @Autowired
    PublisherRepository publisherRepo;

    //Create publisher
    @PostMapping("/publisher")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher postpublisher(@RequestBody Publisher publisher){
        return publisherRepo.save(publisher);
    }

    //Update Books
    @PutMapping("/publisher")
    @ResponseStatus(HttpStatus.OK)
    public Publisher putpublisherr(@RequestBody Publisher publisher){
        return publisherRepo.save(publisher);
    }

    //Get books by ID
    @GetMapping("/publisher/{publisherid}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Publisher> getpublisher(@PathVariable Integer publisherid){
        return publisherRepo.findById(publisherid);
    }

    //Get All Books
    @GetMapping("/publisher")
    @ResponseStatus(HttpStatus.OK)
    public List<Publisher> getpublisherk(){
        return publisherRepo.findAll();
    }

    //DeleteBook by ID
    @DeleteMapping("/publisher/{publisherid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisherById(@PathVariable Integer publisherid){
        publisherRepo.deleteById(publisherid);
    }

}


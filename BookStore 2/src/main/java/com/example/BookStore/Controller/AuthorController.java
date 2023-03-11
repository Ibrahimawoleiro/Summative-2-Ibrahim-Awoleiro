package com.example.BookStore.Controller;

import com.example.BookStore.Model.Author;
import com.example.BookStore.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {

    @Autowired
    AuthorRepository AuthorRepo;

    //Create new Author
    @PostMapping("/author")
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthor(@RequestBody Author author){
        return  AuthorRepo.save(author);
    }

    //Update existing author
    @PutMapping("/author")
    @ResponseStatus(HttpStatus.OK)
    public Author putAuthor(@RequestBody Author author){
        return AuthorRepo.save(author);
    }

    //Read by ID
    @GetMapping("/author/{authorId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Author> getAuthor(@PathVariable Integer authorId){
        return AuthorRepo.findById(authorId);
    }

    //Read all
    @GetMapping("/author")
    @ResponseStatus(HttpStatus.OK)
    public List<Author> getAuthor(){
        return AuthorRepo.findAll();
    }

    //DeletebyId
    @DeleteMapping("/author/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void DeleteAuthor(@PathVariable Integer authorId){
        AuthorRepo.deleteById(authorId);
    }

}

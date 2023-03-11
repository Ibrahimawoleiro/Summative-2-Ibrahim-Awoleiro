package com.example.BookStore.Controller;

import com.example.BookStore.Model.Book;
import com.example.BookStore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository BookRepo;

    //Create Books
    @PostMapping("/Book")
    @ResponseStatus(HttpStatus.CREATED)
    public Book postBook(@RequestBody Book book){
        return BookRepo.save(book);
    }

    //Update Books
    @PutMapping("/Book")
    @ResponseStatus(HttpStatus.OK)
    public Book putBook(@RequestBody Book book){
        return BookRepo.save(book);
    }

    //Get books by ID
    @GetMapping("/Book/{Bookid}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Book> getBook(@PathVariable Integer Bookid){
        return BookRepo.findById(Bookid);
    }

    //Get All Books
    @GetMapping("/Book")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBook(){
        return BookRepo.findAll();
    }

    //DeleteBook by ID
    @DeleteMapping("/Book/{Bookid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void DeleteBook(@PathVariable Integer Bookid){
        BookRepo.deleteById(Bookid);
    }

    //Get by author_id
    @GetMapping("/Book/author/{author_id}")
    @ResponseStatus(HttpStatus.OK)
    public void getByAuthor_id(@PathVariable int author_id){
        BookRepo.findByauthor(author_id);
    }
}

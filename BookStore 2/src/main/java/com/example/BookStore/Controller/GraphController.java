package com.example.BookStore.Controller;

import com.example.BookStore.Model.Author;
import com.example.BookStore.Model.Book;
import com.example.BookStore.Model.Publisher;
import com.example.BookStore.Repository.AuthorRepository;
import com.example.BookStore.Repository.BookRepository;
import com.example.BookStore.Repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class GraphController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    PublisherRepository publisherRepository;

    @QueryMapping()
    public Publisher findByPublisherId(@Argument Integer publisher_id){
        return publisherRepository.findById(publisher_id).get();
    }

    @QueryMapping
    public Optional<Book> findByBookId(@Argument Integer book_id){
        return bookRepository.findById(book_id);
    }

    @QueryMapping
    public Optional<Author> findByAuthorId(@Argument Integer author_id){
        return authorRepository.findById(author_id);
    }

    @SchemaMapping(typeName="Book", field="author")
    public Optional<Author> getAuthor(Book book) {
        Optional<Author> authorHolder = authorRepository.findById(book.getAuthor_id());
        return authorHolder;
    }


    @SchemaMapping(typeName="Book", field="publisher")
    public Optional<Publisher> getPublisher(Book book) {
        Optional<Publisher> publisherHolder = publisherRepository.findById(book.getPublisher_id());
        return publisherHolder;
    }
}

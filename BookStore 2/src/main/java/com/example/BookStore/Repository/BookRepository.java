package com.example.BookStore.Repository;

import com.example.BookStore.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    //find by authorid
    List<Book> findByauthor(int author);
}

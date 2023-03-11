package com.example.BookStore.Repository;

import com.example.BookStore.Model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher,Integer> {

}

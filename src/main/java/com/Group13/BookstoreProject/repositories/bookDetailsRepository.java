package com.Group13.BookstoreProject.repositories;

import com.Group13.BookstoreProject.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface bookDetailsRepository extends MongoRepository<Book, String> {

    @Query("{'id': ?0}")
    Optional<Book> findById(String id);

    @Query("{'isbn': ?0}")
    Optional<List<Book>> findByISBN(String isbn);

}

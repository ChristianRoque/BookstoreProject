package com.Group13.BookstoreProject.Service;

import com.Group13.BookstoreProject.models.Book;
import com.Group13.BookstoreProject.repositories.bookDetailsRepository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface bookDetailsService {

    void addBook(Book book);

    void updateBook(Book book);

    List<Book> getAllBooks();

    Book getBookByID(String id);

    List<Book> getBookByISBN(String isbn);

    List<Book> getBooksByAuthor(String authorID);

    void deleteBook(String id);

    boolean validateBook(String id);

    List<Book> getBooksWithAvgRatingHigherThan(float value);

    List<Book> getSubset(int quantity, int position);

}

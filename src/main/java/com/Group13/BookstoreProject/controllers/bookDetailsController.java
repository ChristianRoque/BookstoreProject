package com.Group13.BookstoreProject.controllers;

import com.Group13.BookstoreProject.repositories.bookDetailsRepository;
import com.Group13.BookstoreProject.Service.bookDetailsServiceImpl;
import com.Group13.BookstoreProject.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class bookDetailsController {
    @Autowired
    private bookDetailsServiceImpl bookService;

    @PostMapping
    public ResponseEntity addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/byID/{id}")
    public ResponseEntity<Book> getBookByID(@PathVariable String id) {
        return ResponseEntity.ok(bookService.getBookByID(id));
    }

    @GetMapping("/byISBN/{isbn}")
    public ResponseEntity<List<Book>> getBookByISBN(@PathVariable String isbn) {
        return ResponseEntity.ok(bookService.getBookByISBN(isbn));
    }

    @GetMapping("/byAuthor/{author}")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable String author) {
        return ResponseEntity.ok(bookService.getBooksByAuthor(author));
    }

    @GetMapping("/isvalid/{id}")
    public boolean validateBook(@PathVariable String id) {
        return bookService.validateBook(id);
    }

    @GetMapping("/ratinghigherthan/{value}")
    public ResponseEntity<List<Book>> getBooksWithRatingAvgHigherThan(@PathVariable float value) {
        return ResponseEntity.ok(bookService.getBooksWithAvgRatingHigherThan(value));
    }

    @GetMapping("/by/{quantity}/from/{position}")
    public ResponseEntity<List<Book>> getSubset(@PathVariable int quantity, @PathVariable int position) {
        return ResponseEntity.ok(bookService.getSubset(quantity, position));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

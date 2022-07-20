package com.Group13.BookstoreProject.Service;

import com.Group13.BookstoreProject.models.Book;
import com.Group13.BookstoreProject.repositories.bookDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class bookDetailsServiceImpl implements bookDetailsService {

    @Autowired
    bookDetailsRepository bookRepository;

    public void addBook(Book book) {

        bookRepository.insert(book);
    }

    public void updateBook(Book book) {

        Optional<Book> searchResults = bookRepository.findById(book.getId());

        if (searchResults.isEmpty()) {
            throw new RuntimeException(String.format("Cannot Find Book by ID %s", book.getId()));
        }

        Book savedBook = searchResults.get();

        savedBook.setISBN(book.getISBN());
        savedBook.setTitle(book.getTitle());
        savedBook.setDescription(book.getDescription());
        savedBook.setPrice(book.getPrice());
        savedBook.setAuthors(book.getAuthors());
        savedBook.setGenre(book.getGenre());
        savedBook.setPublisher(book.getPublisher());
        savedBook.setYearPublished(book.getYearPublished());
        savedBook.setNumSold(book.getNumSold());

        bookRepository.save(savedBook);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookByID(String id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Cannot find Book by ID %s", id)
        ));
    }

    public List<Book> getBookByISBN(String isbn) {
        return bookRepository.findByISBN(isbn).orElseThrow(() -> new RuntimeException(
                String.format("Cannot find Book by ISBN %s", isbn)
        ));
    }

    public List<Book> getBooksByAuthor(String authorID) {

        List<Book> allBooks = getAllBooks();
        List<Book> booksByAuthor = new ArrayList<Book>();

        for (Book book : allBooks) {
            for (String id : book.getAuthors()) {
                if (id.equals(authorID)) {
                    booksByAuthor.add(book);
                    break;
                }
            }
        }

        if (booksByAuthor.isEmpty()) {
            throw new RuntimeException(String.format("Cannot find any Books by Author with ID " + authorID));
        }
        else {
            return booksByAuthor;
        }
    }

    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    public boolean validateBook(String id) {

        Optional<Book> repositoryResults = bookRepository.findById(id);

        return !repositoryResults.isEmpty();
    }

    public List<Book> getBooksWithAvgRatingHigherThan(float value) {

        List<Book> allBooks = getAllBooks();

        List<Book> bookMatches = new ArrayList<Book>();

        for (Book book : allBooks) {
            if (bookAvgValue(book.getId()) >= value) {
                bookMatches.add(book);
            }
        }

        return bookMatches;
    }

    private float bookAvgValue(String bookID) {

        // This path should ultimately be set based on production server installation/configuration, not hard coded
        String uri = "http://localhost:8080/api/rating/avg/";
        uri += bookID;

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, float.class);
    }

    public List<Book> getSubset(int quantity, int position) {

        List<Book> allBooks = getAllBooks();

        if (position >= allBooks.size()) {
            throw new RuntimeException("This starting position exceeds the size of the collection");
        }

        List<Book> subSet = new ArrayList<Book>();

        for (int i = position; (i < allBooks.size()) && quantity > 0;  i++) {
            subSet.add(allBooks.get(i));
            --quantity;
        }

        return subSet;
    }

}

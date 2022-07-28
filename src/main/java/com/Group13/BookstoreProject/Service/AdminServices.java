package com.Group13.BookstoreProject.Service;
import com.Group13.BookstoreProject.repositories.BookRepo;
import com.Group13.BookstoreProject.models.Author;
import com.Group13.BookstoreProject.models.Bookgenre;

import org.springframework.stereotype.Service;

        import java.util.ArrayList;
        import java.util.List;


@Service
public class AdminServices {

    private final BookRepo bookRepo;

    public AdminServices(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void addBooks(Bookgenre book){

        bookRepo.save(book);
    }

    public List<Bookgenre> showAllBooks(){
        return bookRepo.findAll();
    }

    public Bookgenre searchBookByIsbn(String isbn){
        return bookRepo.searchBookByisbnRepo(isbn);
    }

    public List<Bookgenre> searchBookByAuthor(String authorName){
        return bookRepo.searchBookByAuthorRepo(authorName);
    }
/*
    public Book searchBookByTitle(String title){
        return bookRepo.
    }
*/

    public List<Bookgenre> booksByGenre(String genre){
        return bookRepo.searchBookByGenre(genre);
    }

    public ArrayList<Bookgenre> topTenBestSellers(){

        List<Bookgenre> books = showAllBooks();

        List<Bookgenre> booksInOrder = bubbleSortBooksSold(books);

        System.out.println(booksInOrder.get(4));

        ArrayList<Bookgenre> topTenBooks = new ArrayList<>();


        if(booksInOrder.size() < 10){
            for (int i = 0; booksInOrder.size() > i; i++){
                topTenBooks.add(booksInOrder.get(i));

            }
        }
        else {
            for (int i = 0; 10 > i; i++) {
                topTenBooks.add(booksInOrder.get(i));

            }
        }

        return topTenBooks;
    }

    public ArrayList<Bookgenre> searchBooksByXAmount(int xAmount){

        List<Bookgenre> databaseCopy = showAllBooks();

        ArrayList<Bookgenre> xAmountOfBooks = new ArrayList<>();

        for (int i = 0; xAmount > i; i++){

            xAmountOfBooks.add(databaseCopy.get(i));
        }

        return xAmountOfBooks;
    }

    //orders the list of book from most sold to least then returns the book list
    public List<Bookgenre> bubbleSortBooksSold(List<Bookgenre> a) {
        boolean sorted = false;
        Bookgenre temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < a.size() - 1; i++) {
                if (a.get(i).getBooksSold() < a.get(i + 1).getBooksSold()) {
                    temp = a.get(i);
                    a.set(i, a.get(i + 1));
                    a.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
        return a;
    }

}


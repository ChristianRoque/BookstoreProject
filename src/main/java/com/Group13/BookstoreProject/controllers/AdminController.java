package com.Group13.BookstoreProject.controllers;
import com.Group13.BookstoreProject.Service.AdminServices;
import com.Group13.BookstoreProject.models.Bookgenre;
import com.Group13.BookstoreProject.models.Author;
import com.Group13.BookstoreProject.repositories.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/BookstoreProject")
public class AdminController {


    private final AdminServices adminS;

    @Autowired
    private BookRepo bookRepo;

    public AdminController(AdminServices adminS) {
        this.adminS = adminS;
    }

    //Book admin http request

    @PostMapping("/bookcatalog/add_books")
    public void abbBookToDB(@RequestBody final List<Bookgenre> bookList) {


        List<Bookgenre> idmaker;

        for (int i = 0; bookList.size() > i; i++) {

            idmaker = showAllBooks();
            int size;
            int id;

            if (showAllBooks().isEmpty()) {
                id = 1;
            } else {
                size = idmaker.size() - 1;
                id = idmaker.get(size).getBookID() + 1;
            }


            bookList.get(i).setBookID(id);

            adminS.addBooks(bookList.get(i));
        }

    }

    @GetMapping("/bookcatalog/show_all")
    public List<Bookgenre> showAllBooks() {
        return adminS.showAllBooks();
    }

    @GetMapping("/bookcatalog/isbn_search/{isbn}")
    public Bookgenre lookUpByIsbn(@PathVariable String isbn) {
        return adminS.searchBookByIsbn(isbn);
    }

    @GetMapping("/bookcatalog/author_search/{authorName}")
    public List<Bookgenre> showAllAuthorBooks(@PathVariable String authorName) {
        return adminS.searchBookByAuthor(authorName);
    }




    @GetMapping("/bookcatalog/BestSellers")
    public List<Bookgenre> showTopTenBooks() {
        return adminS.topTenBestSellers();
    }

    @GetMapping("/bookcatalog/genre_search/{genre}")
    public List<Bookgenre> showBooksByGenre(@PathVariable String genre) {
        return adminS.booksByGenre(genre);
    }

    @GetMapping("/bookcatalog/show_x_ammount/{xAmmount}")
    public List<Bookgenre> showBooksByXAmmount(@PathVariable Integer xAmmount) {
        return adminS.searchBooksByXAmount(xAmmount);
    }
}
    /*
    public List<Book> showBooksByRating(String stars){
    }

        }


}
*/
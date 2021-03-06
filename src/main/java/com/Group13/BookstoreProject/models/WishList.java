package com.Group13.BookstoreProject.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@TypeAlias("_wishlist") @Document(collection = "wishList")
public class WishList {
    @Id
    private String id = "1";
    private String user = "usernameDefault";
    private String name = "userNameDefault";
    private ArrayList<String> books = new ArrayList<String>();

    public WishList() {
    }

    public WishList(String _id, String _user, String _name, ArrayList<String> _bookList) {
        this.id = _id;
        this.user = _user;
        this.name = _name;
        this.books = _bookList;
    }

    public String getId() {
        return id;
    }

    public void setId(String _id) {
        this.id = _id;
    }

    public String getUser() { return user; }

    public void setUser(String _user) {this.user = _user; }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public void addBook(String _name) {
        this.books.add(_name);
    }

    public void removeBook(String _name) {
        this.books.remove(_name);
    }

    public void setBooks(ArrayList<String> _bookList) {
        this.books = _bookList;
    }

    public ArrayList<String> getBooks(){
        return books;
    }
}

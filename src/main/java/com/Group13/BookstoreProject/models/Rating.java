package com.Group13.BookstoreProject.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;


@TypeAlias("_ratings") @Document(collection = "ratings")
public class Rating {
    @Id
    private String id;
    private double rating;
    private String book;
    private String user;
    private String comment;
    private String date;

    public Rating() {
    }

    public Rating(String _id, double _rating, String _bookId, String _userId, String _comment, String _date) {
        this.id = _id;
        this.rating = _rating;
        this.book = _bookId;
        this.user = _userId;
        this.comment = _comment;
        this.date = _date;
    }

    public String getId() {
        return id;
    }

    public void setId(String _id) {
        this.id = _id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double _rating) {
        this.rating = _rating;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String _bookId) {
        this.book = _bookId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String _userId) {
        this.user = _userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String _comment) {
        this.comment = _comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String _date) {
        this.date = _date;
    }

}

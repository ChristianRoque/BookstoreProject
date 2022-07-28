package com.Group13.BookstoreProject;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

// Creating Comment Entity
@TypeAlias("_comments") @Document(collection = "comments")
public class Comment {
	// initializing values
	@Id
	private String id;
	private double rating;
	private String book;
	private String user;
	private String comment;
	private String date;

	public Comment() {

	}

	// Constructor to assign values to Comment
	public Comment(String _id, double _rating, String _bookId, String _userId, String _comment, String _date)
	{
		this.id = _id;
		this.rating = _rating;
		this.book = _bookId;
		this.user = _userId;
		this.comment = _comment;
		this.date = _date;
	}

	// Getters and setters
	public String getId() { return id; }

	public void setId(String id)
	{
		this.id = id;
	}

	public String getUser()
	{
		return user;
	}

	public void setUser(String firstName)
	{
		this.user = user;
	}

	public double getRating(){
		return rating;
	}

	public void setRating(double _rating) {
		this.rating = _rating;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String _bookID) {
		this.book = _bookID;
	}

	public String getComment()
	{
		return comment;
	}

	public void setComment(String comment)
	{
		this.comment = comment;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String _date) {
		this.date = _date;
	}
}

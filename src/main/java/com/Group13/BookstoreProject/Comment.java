package com.Group13.BookstoreProject;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

// Creating Comment Entity
public class Comment {

	// Constructor to assign values to Comment
	public Comment(String _id, double _rating, String _bookID, String uesrId, String firstName, String lastName,
				   String _comment, String _date)
	{
		super();
		this.id = _id;
		this.rating = _rating;
		this.book = _bookID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.comment = comment;
		this.date = _date;
	}

	// initializing values
	private String id;
	private String book;
	private double rating;
	private String firstName;
	private String lastName;
	private String comment;
	private String date;

	// Overriding the toString method to find all the values
	@Override
	public String toString()
	{
		return "Comment [id="
				+ id + "book=" + book + "rating =" + rating + ", firstName="
				+ firstName + ", lastName="
				+ lastName + ", comment="
				+ comment + "date" + date + "]";
	}

	// Getters and setters
	public String getId() { return id; }

	public void setId(String id)
	{
		this.id = id;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
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

package com.Group13.BookstoreProject;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

// Creating Comment Entity
public class Comment {
	public static void main(String[] args) {
		Comment c1 = new Comment(2, "Tom", "Henderson", "I love everything!");
		System.out.print(c1);
	}
	public Comment() {}

	// Constructor to assign values to Comment
	public Comment(Integer id, String firstName, String lastName, String comment)
	{
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.comment = comment;
	}

	private Integer id;
	private String firstName;
	private String lastName;
	private String comment;

	// Overriding the toString method to find all the values
	@Override
	public String toString()
	{
		return "Comment [id="
				+ id + ", firstName="
				+ firstName + ", lastName="
				+ lastName + ", comment="
				+ comment + "]";
	}

	// Getters and setters
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getComment()
	{
		return comment;
	}

	public void setComment(String comment)
	{
		this.comment = comment;
	}


}

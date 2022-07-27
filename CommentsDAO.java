package com.Group13.BookstoreProject;
import org.springframework.stereotype.Repository;

@Repository
public class CommentsDAO {
    private static Comments list
            = new Comments();

    // This static block is executed before executing the main block
    static
    {
        // Creating a few comments and adding them to the list
        list.getCommentList().add(
                new Comment(
                        1,
                        "Kuro",
                        "Sawa",
                        "I love this book."));

        list.getCommentList().add(
                new Comment(
                        2,
                        "Vikash",
                        "Kumar",
                        "I hated this book."));

        list.getCommentList().add(
                new Comment(
                        3,
                        "Ritesh",
                        "Ojha",
                        "This book was okay."));


    }



    // Method to return the list
    public Comments getAllComments()
    {
        return list;
    }


    // Method to add a comment to the comments list
    public void
    addComment(Comment comment)
    {
        list.getCommentList().add(comment);
    }
}

package com.Group13.BookstoreProject;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// Import the above-defined classes to use the properties of those classes


// Creating the REST controller
@RestController
@RequestMapping(path = "/comments")
public class CommentController {
    @Autowired
    private CommentsDAO commentsDao;

    // Implementing a GET method to get the list of all the comments
    @GetMapping(
            path = "/",
            produces = "application/json")

    public Comments getComments()
    {
        return commentsDao.getAllComments();
    }


    // Create a POST method to add a comment to the list
    @PostMapping(
            path = "/",
            consumes = "application/json",
            produces = "application/json")

    public ResponseEntity<Object> addComment(
            @RequestBody Comment comment)
    {

        // Creating an ID of the comment from the number of comments
        Integer id = commentsDao.getAllComments().getCommentList().size() + 1;

        comment.setId(id);

        commentsDao.addComment(comment);

        URI location
                = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(comment.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
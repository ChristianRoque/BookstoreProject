package com.Group13.BookstoreProject;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(value ="/")
    public List<Rating> getAllRatings() {
        return commentReposity.findAllRatings();
    }

    @GetMapping(value="/{_id}")
    public Rating getRatingById(@PathVariable String _id) {
        return commentRepository.findRatingById(_id);
    }

    @GetMapping(value="/book/{_id}")
    public List<Rating> getRatingByBookId(@PathVariable String _id) {
        return commentReposity.findRatingByBookId(_id);
    }

    @GetMapping(value="/user/{_id}")
    public List<Rating> getRatingByUserId(@PathVariable String _id) {
        return commentReposity.findRatingByUserId(_id);
    }

    @GetMapping(value="/date/{_date}")
    public List<Rating> getRatingByDate(@PathVariable String _date) {
        return commentReposity.findRatingByDate(_date);
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
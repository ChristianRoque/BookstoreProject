package com.Group13.BookstoreProject;

import java.util.List;

import com.Group13.BookstoreProject.Service.CommentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Import the above-defined classes to use the properties of those classes
    // Creating the REST controller
    @RestController
    @RequestMapping("/comments")
    public class CommentController {

        @Autowired
        private CommentServiceImplementation commentReposity;

        @PostMapping(value="/create")
        public void newComment(@RequestBody Comment comment) {
            this.commentReposity.createComment(comment);
        }

        @GetMapping(value ="/")
        public List<Comment> getAllComments() {
            return commentReposity.findAllComments();
        }

        @GetMapping(value="/{_id}")
        public Comment getCommentById(@PathVariable String _id) {
            return commentReposity.findCommentById(_id);
        }

        @GetMapping(value="/book/{_Id}")
        public List<Comment> getCommentByBookId(@PathVariable String _Id) {
            return commentReposity.findCommentByBookId(_Id);
        }

        @GetMapping(value="/user/{_Id}")
        public List<Comment> getCommentByUserId(@PathVariable String _Id) {
            return commentReposity.findCommentByUserId(_Id);
        }

        @GetMapping(value="/date/{_date}")
        public List<Comment> getCommentByDate(@PathVariable String _date) {
            return commentReposity.findCommentByDate(_date);
        }

        @PutMapping(value ="/update")
        public void saveExistingComment(@RequestBody Comment _comment) {
            commentReposity.updateComment(_comment);
        }

        @DeleteMapping(value = "/{_id}")
        public void deleteComment(@PathVariable String _id) {
            commentReposity.deleteComment(_id);
        }
    }
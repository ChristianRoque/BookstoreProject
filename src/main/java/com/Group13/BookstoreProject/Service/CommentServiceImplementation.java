package com.Group13.BookstoreProject.Service;

import com.Group13.BookstoreProject.Comment;
import com.Group13.BookstoreProject.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImplementation implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void createComment(Comment _comment) {
        System.out.println(_comment.getBook());
        commentRepository.insert(_comment);
    }

    @Override
    public List<Comment> findAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findCommentById(String _id) {
        return commentRepository.findCommentById(_id);
    }

    @Override
    public List<Comment> findCommentByBookId(String _bookId) {
        return commentRepository.findBookId(_bookId);
    }

    @Override
    public List<Comment> findCommentByUserId(String _userId) {
        return commentRepository.findUserByID(_userId);
    }

    @Override
    public List<Comment> findCommentByDate(String _date) {
        return commentRepository.findDateBy(_date);
    }

    @Override
    public void updateComment(Comment _comment) {
        commentRepository.save(_comment);
    }

    @Override
    public void updateRating(Comment _rating) {
        commentRepository.save(_rating);
    }

    @Override
    public void deleteComment(String _id) {
        commentRepository.deleteById(_id);
    }

    @Override
    public double getAverage(String _bookId) {
        List<Comment> mylist = commentRepository.findBookId(_bookId);
        double rating = 0;
        for (int i = 0; i < mylist.size(); i++) {
            if (mylist.size() >= 0) {
                rating += mylist.get(i).getRating();
            }
        }
        System.out.println("Average rating: " + rating/mylist.size());
        return rating/mylist.size();
    }

}
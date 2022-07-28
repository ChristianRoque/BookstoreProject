package com.Group13.BookstoreProject.Service;

import com.Group13.BookstoreProject.Comment;
import com.Group13.BookstoreProject.repositories.CommentRepository;

import java.util.List;

public interface CommentService {

    void createComment(Comment _rating);

    List<Comment> findAllComments();

    Comment findCommentById(String _id);

    List<Comment> findCommentByBookId(String _bookId);

    List<Comment> findCommentByUserId(String _userId);

    List<Comment> findCommentByDate(String _date);

    void updateComment(Comment comment);

    void updateRating(Comment _rating);

    void deleteComment(String _id);

    double getAverage(String _bookId);
}
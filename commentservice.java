package com.Group13.BookstoreProject.Service;


import com.Group13.BookstoreProject.Comment;
import java.util.List;

public interface CommentService {

    void createRating(Comment _rating);

    List<Comment> findAllRatings();

    Comment findRatingById(String _id);

    List<Comment> findRatingByBookId(String _bookId);

    List<Comment> findRatingByUserId(String _userId);

    List<Comment> findRatingByDate(String _date);

    void updateRating(Comment _rating);

    void deleteRating(String _id);
}
package com.Group13.BookstoreProject.Service;

import com.Group13.BookstoreProject.Rating;
import java.util.List;

public interface RatingService {

    void createRating(Rating _rating);

    List<Rating> findAllRatings();

    Rating findRatingById(String _id);

    List<Rating> findRatingByBookId(String _bookId);

    List<Rating> findRatingByUserId(String _userId);

    List<Rating> findRatingByDate(String _date);

    void updateRating(Rating _rating);

    void deleteRating(String _id);
}
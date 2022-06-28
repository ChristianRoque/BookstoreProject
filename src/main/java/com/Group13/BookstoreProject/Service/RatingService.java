package com.Group13.BookstoreProject.Service;

import com.Group13.BookstoreProject.models.Rating;
import java.util.List;
import java.util.Optional;

public interface RatingService {

    void createRating(Rating _rating);

    List<Rating> findAllRatings();

    Rating findRatingById(String _id);

    Rating findRatingByBookId(String _bookId);

    Rating findRatingByUserId(String _userId);

    Rating findRatingByDate(String _date);

    void updateRating(Rating _rating);

    void deleteRating(String _id);
}

package com.Group13.BookstoreProject.Service;

import com.Group13.BookstoreProject.models.Rating;
import com.Group13.BookstoreProject.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public void createRating(Rating _rating) {
        System.out.println(_rating.getBook());
        ratingRepository.insert(_rating);
    }

    @Override
    public List<Rating> findAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating findRatingById(String _id) {
        return ratingRepository.findRatingById(_id);
    }

    @Override
    public Rating findRatingByBookId(String _bookId) {
        return ratingRepository.findBookId(_bookId);
    }

    @Override
    public Rating findRatingByUserId(String _userId) {
        return ratingRepository.findUserByID(_userId);
    }

    @Override
    public Rating findRatingByDate(String _date) {
        return ratingRepository.findDateBy(_date);
    }

    @Override
    public void updateRating(Rating _rating) {
        ratingRepository.save(_rating);
    }

    @Override
    public void deleteRating(String _id) {
        ratingRepository.deleteById(_id);
    }
}

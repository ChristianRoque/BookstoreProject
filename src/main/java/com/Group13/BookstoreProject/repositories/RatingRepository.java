package com.Group13.BookstoreProject.repositories;

import com.Group13.BookstoreProject.models.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface RatingRepository extends MongoRepository<Rating, String> {
    @Query("{id: '?0'}")
    Rating findRatingById(String id);
    @Query("{book: '?0'}")
    Rating findBookId(String bookId);
    @Query("{book: '?0'}")
    Rating findUserByID(String userId);
    @Query("{date: '?0'}")
    Rating findDateBy(String date);
}

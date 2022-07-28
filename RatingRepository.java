package com.Group13.BookstoreProject.repositories;

import com.Group13.BookstoreProject.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {
    @Query("{id: '?0'}")
    Rating findRatingById(String id);
    @Query("{book: '?0'}")
    List<Rating> findBookId(String bookId);
    @Query("{book: '?0'}")
    List<Rating> findUserByID(String userId);
    @Query("{date: '?0'}")
    List<Rating> findDateBy(String date);
}
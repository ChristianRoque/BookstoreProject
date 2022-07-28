package com.Group13.BookstoreProject.repositories;

import com.Group13.BookstoreProject.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {
    @Query("{id: '?0'}")
    Comment findCommentById(String id);
    @Query("{book: '?0'}")
    List<Comment> findBookId(String bookId);
    @Query("{book: '?0'}")
    List<Comment> findUserByID(String userId);
    @Query("{date: '?0'}")
    List<Comment> findDateBy(String date);
   //@Query("{rating: '?0}")
    //List<Comment> findRating(double rating);
   @Query("Select rating FROM comments rating WHERE comments.id=:id")
    List<Comment> getById(@Param("id")String id);
}
package com.Group13.BookstoreProject.repositories;

import com.Group13.BookstoreProject.models.WishList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface WishListRepository extends MongoRepository<WishList, String> {
    @Query("{user: '?0'}")
    List<WishList> findWishListByUser(String _id);
    @Query("{id: '?0'}")
    WishList findWishListById(String _id);
    @Query("{name: '?0'}")
    WishList findWishListByName(String _name);
}

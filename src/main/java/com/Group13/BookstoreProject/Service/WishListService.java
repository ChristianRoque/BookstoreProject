package com.Group13.BookstoreProject.Service;

import com.Group13.BookstoreProject.models.WishList;
import java.util.List;

public interface WishListService {

    void createWishList(WishList _wishList);

    WishList getWishListById(String _name);

    List<WishList> getWishListByUser(String _id);

    WishList getWishListByName(String _id);

    List<WishList> getAllWishList();

    void updateWishList(WishList _wishList);

    void addBookWishList(String _id, String _bookName);

    void removeBookWishList(String _id, String _bookName);

    void deleteWishList(String _id);
}

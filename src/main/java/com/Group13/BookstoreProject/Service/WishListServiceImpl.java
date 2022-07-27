package com.Group13.BookstoreProject.Service;

import com.Group13.BookstoreProject.models.WishList;
import com.Group13.BookstoreProject.repositories.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class WishListServiceImpl implements WishListService {

    @Autowired
    WishListRepository wishListRepository;

    @Override
    public void createWishList(WishList _wishList) {
        wishListRepository.insert(_wishList);
    }

    @Override
    public WishList getWishListById(String _id) {
        return wishListRepository.findWishListById(_id);
    }

    @Override
    public List<WishList> getWishListByUser(String _id) {
        return wishListRepository.findWishListByUser(_id);
    }

    @Override
    public WishList getWishListByName(String _name) {
        return wishListRepository.findWishListByName(_name);
    }

    @Override
    public List<WishList> getAllWishList() {
        return wishListRepository.findAll();
    }

    @Override
    public void updateWishList(WishList _wishList) {
        if(wishListRepository.findWishListById(_wishList.getName()) != null) {
            wishListRepository.save(_wishList);
        }
    }

    @Override
    public void addBookWishList(String _id, String _bookName){
        WishList savedWishList = wishListRepository.findWishListById(_id);
        if ( savedWishList != null) {
            savedWishList.addBook(_bookName);
            wishListRepository.save(savedWishList);
        }
    }

    @Override
    public void removeBookWishList(String _id, String _bookName) {
        WishList savedWishList = wishListRepository.findWishListById(_id);
        if (savedWishList.getBooks().contains(_bookName)) {
            savedWishList.removeBook(_bookName);
            wishListRepository.save(savedWishList);
        }
    }

    @Override
    public void deleteWishList(String _id) {
        wishListRepository.deleteById(_id);
    }
}

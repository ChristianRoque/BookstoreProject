package com.Group13.BookstoreProject.Service;

import com.Group13.BookstoreProject.models.WishList;
import com.Group13.BookstoreProject.repositories.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class WishListServiceImpl implements WishListService {

    @Autowired
    WishListRepository wishListRepository;

    @Override
    public void createWishList(WishList _wishList) {
        boolean unique = wishListRepository.findWishListByName(_wishList.getName()).getName() == null;
        if (!unique) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Wishlist already exists");
        }
        if (wishListRepository.findWishListByUser(_wishList.getUser()).size() >= 3)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User already has another three other wishlists.Please delete one.");
        }
        else {
            wishListRepository.insert(_wishList);
        }
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
        if(wishListRepository.findWishListById(_wishList.getId()) == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cannot update.Entry does not exist.");
        } else {
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

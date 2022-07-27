package com.Group13.BookstoreProject.controllers;
import com.Group13.BookstoreProject.models.WishList;

import com.Group13.BookstoreProject.Service.WishListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishListController {

    @Autowired
    private WishListServiceImpl wishListReposity;

    @PostMapping(value="/create")
    public void createWishList(@RequestBody WishList _wishList) {
        wishListReposity.createWishList(_wishList);
    }

    @GetMapping(value="/")
    public List<WishList> getAllWishlist() {
        return wishListReposity.getAllWishList();
    }

    @GetMapping(value="/id/{_id}")
    public WishList getWishListById(@PathVariable String _id) {
        return wishListReposity.getWishListById(_id);
    }

    @GetMapping(value="/name/{_name}")
    public WishList getWishListByName(@PathVariable String _id) {
        return wishListReposity.getWishListById(_id);
    }

    @GetMapping(value="/user/{_id}")
    public List<WishList> getWishListByUserId(@PathVariable String _id) {
        return wishListReposity.getWishListByUser(_id);
    }

    @PutMapping(value="/user/{_id}/add")
    public void addBookWishList(@PathVariable String _id, @RequestBody String _book) {
        wishListReposity.addBookWishList(_id,_book);
    }

    @PutMapping(value="/user/{_id}/remove")
    public void removeBookWishList(@PathVariable String _id, @RequestBody String _book) {
        wishListReposity.removeBookWishList(_id,_book);
    }

    @PutMapping(value="/update")
    public void updateWishList(@RequestBody WishList _wishList) {
        wishListReposity.updateWishList(_wishList);
    }

    @DeleteMapping(value="/delete/{_id}")
    public void removeBookWishList(@PathVariable String _id) {
        wishListReposity.deleteWishList(_id);
    }
}

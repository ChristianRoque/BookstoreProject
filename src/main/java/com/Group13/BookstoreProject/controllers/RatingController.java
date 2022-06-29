package com.Group13.BookstoreProject.controllers;
import com.Group13.BookstoreProject.models.Rating;

import com.Group13.BookstoreProject.Service.RatingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingServiceImpl ratingReposity;

    @PutMapping(value="/create")
    public void newRating(@RequestBody Rating rating) {
        this.ratingReposity.createRating(rating);
    }

    @GetMapping(value ="/")
    public List<Rating> getAllRatings() {
        return ratingReposity.findAllRatings();
    }

    @GetMapping(value="/{_id}")
    public Rating getRatingById(@PathVariable String _id) {
        return ratingReposity.findRatingById(_id);
    }

    @GetMapping(value="/book/{_id}")
    public List<Rating> getRatingByBookId(@PathVariable String _id) {
        return ratingReposity.findRatingByBookId(_id);
    }

    @GetMapping(value="/user/{_id}")
    public List<Rating> getRatingByUserId(@PathVariable String _id) {
        return ratingReposity.findRatingByUserId(_id);
    }

    @GetMapping(value="/date/{_date}")
    public List<Rating> getRatingByDate(@PathVariable String _date) {
        return ratingReposity.findRatingByDate(_date);
    }

    @PostMapping(value ="/update")
    public void saveExistingRating(@RequestBody Rating _rating) {
        ratingReposity.updateRating(_rating);
    }

    @DeleteMapping(value = "/{_id}")
    public void deleteRating(@PathVariable String _id) {
        ratingReposity.deleteRating(_id);
    }
}

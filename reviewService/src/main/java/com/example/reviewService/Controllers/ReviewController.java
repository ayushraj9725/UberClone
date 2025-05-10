package com.example.reviewService.Controllers;

import com.example.reviewService.Models.Review;
import com.example.reviewService.Services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {


    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService ;
    }

    @PostMapping // use postMapping for creating a new review using api
    public ResponseEntity<Review> publishReview(@RequestBody Review request){
        Review review = this.reviewService.publishReview(request);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }


    @GetMapping  // only using getMapping for finding all the reviews at a time
    public ResponseEntity<List<Review>> getAllReviews(){
        List<Review> reviews = this.reviewService.findAllReviews();
        return new ResponseEntity<>(reviews,HttpStatus.OK);
    }

    // getMapping  using the path variable reviewId / v1/v2 ets

    @GetMapping("/{reviewId}")
    public ResponseEntity<?> findReviewById(@PathVariable Long reviewId){
        try{
            Optional<Review> review = this.reviewService.findReviewById(reviewId);
            return new ResponseEntity<>(review,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    // now we are going to delete the review using deleteMapping over her below
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteReviewById(@PathVariable Long reviewId){

        try{
            boolean isDeleted = this.reviewService.deleteReviewById(reviewId);
            if(isDeleted){
                return new ResponseEntity<>("unable to delete review on " + reviewId , HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>("Delete Review Succesfully ",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    // now we are going to update the review using putMapping over here below , by specifying some data not all

    @PutMapping("/{reviewId}")
    public ResponseEntity<?> updateReview(@PathVariable Long reviewId , Review request){
        try{
            Review review = this.reviewService.updateReview(reviewId,request);
            return new ResponseEntity<>(review,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

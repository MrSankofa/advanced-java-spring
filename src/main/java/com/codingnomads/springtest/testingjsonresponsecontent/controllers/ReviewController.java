/* CodingNomads (C)2023 */
package com.codingnomads.springtest.testingjsonresponsecontent.controllers;

import com.codingnomads.springtest.testingjsonresponsecontent.exceptions.NoSuchRecipeException;
import com.codingnomads.springtest.testingjsonresponsecontent.exceptions.NoSuchReviewException;
import com.codingnomads.springtest.testingjsonresponsecontent.models.Recipe;
import com.codingnomads.springtest.testingjsonresponsecontent.models.Review;
import com.codingnomads.springtest.testingjsonresponsecontent.services.ReviewService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getReviewById(@PathVariable("id") Long id) {
        try {
            Review retrievedReview = reviewService.getReviewById(id);
            return ResponseEntity.ok(retrievedReview);
        } catch (IllegalStateException | NoSuchReviewException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/recipe/{recipeId}")
    public ResponseEntity<?> getReviewByRecipeId(@PathVariable("recipeId") Long recipeId) {
        try {
            ArrayList<Review> reviews = reviewService.getReviewByRecipeId(recipeId);
            return ResponseEntity.ok(reviews);
        } catch (NoSuchRecipeException | NoSuchReviewException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<?> getReviewByUsername(@PathVariable("username") String username) {
        try {
            ArrayList<Review> reviews = reviewService.getReviewByUsername(username);
            return ResponseEntity.ok(reviews);
        } catch (NoSuchReviewException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{recipeId}")
    public ResponseEntity<?> postNewReview(@RequestBody Review review, @PathVariable("recipeId") Long recipeId) {
        try {
            Recipe insertedRecipe = reviewService.postNewReview(review, recipeId);
            return ResponseEntity.created(insertedRecipe.getLocationURI()).body(insertedRecipe);
        } catch (NoSuchRecipeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReviewById(@PathVariable("id") Long id) {
        try {
            Review review = reviewService.deleteReviewById(id);
            return ResponseEntity.ok(review);
        } catch (NoSuchReviewException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping
    public ResponseEntity<?> updateReviewById(@RequestBody Review reviewToUpdate) {
        try {
            Review review = reviewService.updateReviewById(reviewToUpdate);
            return ResponseEntity.ok(review);
        } catch (NoSuchReviewException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

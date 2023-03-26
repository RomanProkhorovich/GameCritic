package com.example.Controllers;

import com.example.Models.Review;
import com.example.Services.Interface.ReviewServiceInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/review")
public class ReviewController {

    private final ReviewServiceInterface reviews;

    public ReviewController(@Qualifier("ReviewServiceInterface") ReviewServiceInterface rev) {
        this.reviews = rev;
    }

    @GetMapping("/{id}")
    public String getReview(Model model, @PathVariable(value = "id") Long Id) {
        model.addAttribute("genre", reviews.findReviewById(Id).orElse(null));
        return "genre";
    }

    public String getAllReviews(Model model) {
        model.addAttribute("genres", reviews.findAll());
        return "AllGenres";
    }

    @PostMapping
    public void addNewReview(Review review) {
        reviews.save(review);
    }
}

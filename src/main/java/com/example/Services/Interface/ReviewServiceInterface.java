package com.example.Services.Interface;

import com.example.Models.Comment;
import com.example.Models.Game;
import com.example.Models.Review;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ReviewServiceInterface {
    List<Review> findAllByGame(Game game);
    Review save(Review r);
    Optional<Review> findReviewById(Long id);
    List<Review> findAll();

    void addComment(Long id,Comment comment);
    void addComment(Review rev,Comment comment);
}

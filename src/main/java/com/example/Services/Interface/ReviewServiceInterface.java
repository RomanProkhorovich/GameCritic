package com.example.Services.Interface;

import com.example.Models.Game;
import com.example.Models.Review;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewServiceInterface {
    List<Review> findAllByGame(Game game);
    Review save(Review r);
}

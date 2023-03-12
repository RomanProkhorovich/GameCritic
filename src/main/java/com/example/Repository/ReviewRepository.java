package com.example.Repository;

import com.example.Models.Game;
import com.example.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findAllByGame(Game game);
}

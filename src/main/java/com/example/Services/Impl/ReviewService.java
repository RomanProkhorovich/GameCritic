package com.example.Services.Impl;

import com.example.Models.Game;
import com.example.Models.Genre;
import com.example.Models.Review;
import com.example.Repository.ReviewRepository;
import com.example.Services.Interface.CommentServiceInterface;
import com.example.Services.Interface.GameServiceInterface;
import com.example.Services.Interface.ReviewServiceInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Qualifier("ReviewServiceInterface")
public class ReviewService implements ReviewServiceInterface {
    private final ReviewRepository repo;
    private final GameServiceInterface games;
    private final CommentServiceInterface comments;

    public ReviewService(ReviewRepository repo
            , @Qualifier("GameServiceInterface") GameServiceInterface games
            , @Qualifier("CommentServiceInterface") CommentServiceInterface comments) {
        this.repo = repo;
        this.games = games;
        this.comments = comments;
    }

    @Override
    public List<Review> findAllByGame(Game game) {
        return repo.findAllByGame(game);
    }

    @Override
    public Review save(Review r) {
        var a=games.save(r.getGame());
        r.setGame(a);
        return  repo.save(r);
    }
}

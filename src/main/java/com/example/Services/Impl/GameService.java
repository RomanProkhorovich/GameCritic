package com.example.Services.Impl;

import com.example.Exceptions.GameNotFoundException;
import com.example.Models.Game;
import com.example.Models.Genre;
import com.example.Repository.GameRepository;
import com.example.Services.Interface.GameServiceInterface;
import com.example.Services.Interface.GenreServiceInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Qualifier("GameServiceInterface")
public class GameService implements GameServiceInterface {
    private final GameRepository repository;
    private final GenreServiceInterface genres;

    public GameService(GameRepository rep, @Qualifier("GenreServiceInterface") GenreServiceInterface genres) {
        repository = rep;
        this.genres = genres;
    }

    public List<Game> findAll() {

        return repository.findAll();
    }

    public Optional<Game> findById(long id)  {
        return repository.findById(id);
    }

    @Override
    public Game save(Game g) {
        if (g==null)
            return null;
        Set<Genre> genresSet = new HashSet<>();

        for (var genre : g.getGenres()) {
            genresSet.add(genres.save(genre));
        }
        g.setGenres(genresSet);

        if (findGameByTitle(g.getTitle()).isEmpty()) {
            return repository.save(g);
        }
        return findGameByTitle(g.getTitle()).get();
    }

    @Override
    public Optional<Game> findGameByTitle(String name) {
        return repository.findGameByTitle(name);
    }
}

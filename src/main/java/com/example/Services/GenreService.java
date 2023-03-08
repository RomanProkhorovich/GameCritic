package com.example.Services;


import com.example.Models.Genre;
import com.example.Repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenreService implements GenreServiceInterface{
    private final GenreRepository repo;

    public GenreService(GenreRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Genre> findAllGenres() {
        return repo.findAll();
    }
}

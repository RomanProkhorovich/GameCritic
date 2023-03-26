package com.example.Services.Impl;


import com.example.Models.Genre;
import com.example.Repository.GenreRepository;
import com.example.Services.Interface.GenreServiceInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("GenreServiceInterface")
public class GenreService implements GenreServiceInterface {
    private final GenreRepository repo;

    public GenreService(GenreRepository repo) {
        this.repo = repo;
    }

    @Override
    public Optional<Genre> findGenreById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Genre> findAllGenres() {
        return repo.findAll();
    }
    public Optional<Genre> findByName(String genreName){
        return repo.findGenreByName(genreName);
    }

    public Genre save(Genre g) {
        if (g==null)
            return null;
        if(repo.findGenreByName(g.getName()).isEmpty()){
            return repo.save(g);
        }
      return repo.findGenreByName(g.getName()).get();
    }

    @Override
    public Optional<Genre> findGenreByName(String name) {
        return  repo.findGenreByName(name);
    }
}

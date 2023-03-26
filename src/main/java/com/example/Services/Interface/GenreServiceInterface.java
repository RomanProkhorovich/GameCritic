package com.example.Services.Interface;

import com.example.Models.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service/*
@Qualifier("GenreServiceInterface")*/

public interface GenreServiceInterface {
    List<Genre> findAllGenres();
    Genre save(Genre g);
    Optional<Genre> findGenreByName(String name);
    Optional<Genre> findGenreById(Long id);
}

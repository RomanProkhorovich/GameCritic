package com.example.Services;

import com.example.Models.Genre;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GenreServiceInterface {
    List<Genre> findAllGenres();
}

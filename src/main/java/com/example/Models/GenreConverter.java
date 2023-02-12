package com.example.Models;

import com.example.Repository.GenreRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public  class GenreConverter {
    private static GenreRepository repo;

    public  GenreConverter(GenreRepository repo) {
        GenreConverter.repo = repo;
    }

    public static String getGenreById(Long id) {
        return repo.findById(id).get().getName();
    }

    public Long getIdByGenre(String name){
        return  repo.findGenreByName(name).getId();
    }
}

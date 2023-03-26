package com.example.Controllers;

import com.example.Models.Genre;
import com.example.Services.Interface.GenreServiceInterface;
import org.junit.jupiter.params.aggregator.ArgumentAccessException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/genres")
public class GenreController {

    private final GenreServiceInterface genres;

    public GenreController(@Qualifier("GenreServiceInterface") GenreServiceInterface genres) {
        this.genres = genres;
    }
    @GetMapping("/{id}")
    public String getGenre(Model model, @PathVariable(value = "id") Long Id){
        model.addAttribute("genre",genres.findGenreById(Id).orElse(null));
        return "genre";
    }

    public String getAllGenres(Model model){
        model.addAttribute("genres",genres.findAllGenres());
        return  "AllGenres";
    }

    @PostMapping
    public void addNewGenre(@RequestBody Genre genre){
        genres.save(genre);
    }
}

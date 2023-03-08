package com.example.Controllers;

import com.example.Repository.GenreRepository;
import com.example.Services.GameService;
import com.example.Services.GenreService;
import com.example.Services.GenreServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/add_new_title")
public class AddNewTitleController {

    final private GameService games;
    final private GenreService genres;

    public AddNewTitleController(GameService games, GenreService genres) {
        this.games = games;
        this.genres = genres;
    }


    @GetMapping
    public String printFormToAdd(Model model){
        model.addAttribute( "genres", genres.findAllGenres());
        return "add_new_title";
    }

}

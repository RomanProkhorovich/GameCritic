package com.example.Controllers;

import com.example.Models.Game;
import com.example.Services.Impl.GameService;
import com.example.Services.Impl.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @PostMapping
    public Game addNewGame(@RequestBody Game game){
        return games.save(game);
    }

}

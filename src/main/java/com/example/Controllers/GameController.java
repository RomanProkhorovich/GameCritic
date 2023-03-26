package com.example.Controllers;

import com.example.Services.Impl.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GameController {

    final GameService gm;


    public GameController(GameService g) {
        gm = g;
    }

    @GetMapping("/")
    public String games(Model model) {
        model.addAttribute("games", gm.findAll());
        return "games";
    }

    @GetMapping("/game/{id}")
    public String game(Model model, @PathVariable("id") Long Id) {

        model.addAttribute("gamebyid", gm.findById(Id));
        return "gamebyid";
    }


}

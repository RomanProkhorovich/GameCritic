package com.example.Controllers;

import com.example.Models.Game;
import com.example.Services.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {
    GameService gm=new GameService();
    public  GameController(GameService g){
        gm=g;
    }
    @GetMapping("/")
    public String games(Model model){
        model.addAttribute("games", gm.search());
        return "games";
    }
}

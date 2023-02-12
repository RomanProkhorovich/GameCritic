package com.example.API;

import com.example.Models.Game;
import com.example.Repository.GameRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api",
        produces="application/json")
@CrossOrigin(origins="http://localhost:8080")

public class APIGameController {

    private final GameRepository repo;

    public APIGameController(GameRepository repo) {
        this.repo = repo;
    }

    @GetMapping(params = "all")
    public Iterable<Game> getAll(){
        return repo.findAll();
    }
}


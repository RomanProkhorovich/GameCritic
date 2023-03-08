package com.example.API;

import com.example.Models.Game;
import com.example.Repository.GameRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path="/api/",
        produces="application/json")
@CrossOrigin(origins="http://localhost:8080")

public class APIGameController {

    private final GameRepository repo;

    public APIGameController(GameRepository repo) {
        this.repo = repo;
    }

    @GetMapping(params = "all")
    public ResponseEntity<List<Game>> getAll(){
        return ResponseEntity
                .ok()
                .body(repo.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Game> getById(@PathVariable("id") Long id){
        return  ResponseEntity.of(repo.findById(id));
    }

    @GetMapping("name={title}")
    public ResponseEntity<Game> getById(@PathVariable("title") String title){
        return  ResponseEntity.of(repo.findGameByTitle(title));
    }


}


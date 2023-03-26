package com.example.API;

import com.example.Models.Game;
import com.example.Services.Interface.GameServiceInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/games")
public class APIGameController  {

    private final GameServiceInterface repo;

    public APIGameController(@Qualifier("GameServiceInterface") GameServiceInterface repo) {
        this.repo = repo;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('developers:read')")
    public ResponseEntity<List<Game>> getAll(){
        return ResponseEntity
                .ok()
                .body(repo.findAll());
    }

    @GetMapping("id={id}")
    @PreAuthorize("hasAuthority('developers:read')")
    public ResponseEntity<Game> getById(@PathVariable("id") Long id){
        return  ResponseEntity.of(repo.findById(id));
    }

    @GetMapping("title={title}")
    @PreAuthorize("hasAuthority('developers:read')")
    public ResponseEntity<Game> getByTitle(@PathVariable("title") String title){
        return  ResponseEntity.of(repo.findGameByTitle(title));
    }
    @PostMapping
    @PreAuthorize("hasAuthority('developers:write')")
    public ResponseEntity<Game> addGame(@RequestBody Game game){
        return ResponseEntity
                .ok()
                .body(repo.save(game));
    }


}


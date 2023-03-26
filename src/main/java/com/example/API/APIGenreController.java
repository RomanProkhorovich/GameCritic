package com.example.API;

import com.example.Models.Genre;
import com.example.Services.Interface.GenreServiceInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/genres")
public class APIGenreController {
    private final GenreServiceInterface genres;

    public APIGenreController(@Qualifier("GenreServiceInterface") GenreServiceInterface genres) {
        this.genres = genres;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('developers:read')")
    public ResponseEntity<List<Genre>> get() {
        return ResponseEntity
                .ok()
                .body(genres.findAllGenres());
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('developers:read')")
    public ResponseEntity<Genre> get(@PathVariable("id") Long id) {

        return ResponseEntity.of(genres.findGenreById(id));

    }

    @PostMapping
    @PreAuthorize("hasAuthority('developers:write')")
    public ResponseEntity<Genre> add(@RequestBody Genre genre) {
        return ResponseEntity.ok(genres.save(genre));
    }
}

package com.example.Services.Interface;

import com.example.Exceptions.GameNotFoundException;
import com.example.Models.Game;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GameServiceInterface {

    List<Game> findAll();

    Game findAll(long id) throws GameNotFoundException;

    Game save(Game g);

    Optional<Game> findGameByTitle(String name);

}

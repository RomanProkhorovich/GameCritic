package com.example.Services;

import com.example.Exceptions.GameNotFoundException;
import com.example.Models.Game;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameServiceInterface {

     List<Game> findAllGames();

    Game findAllGames(long id) throws GameNotFoundException;

    void addNewGameTitle(Game game);
}

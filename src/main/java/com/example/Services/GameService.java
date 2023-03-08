package com.example.Services;
import com.example.Exceptions.GameNotFoundException;
import com.example.Models.Game;
import com.example.Repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class GameService implements GameServiceInterface {
    private final  GameRepository  repository;
    public GameService(GameRepository rep)
    {
        repository=rep;
    }
    public List<Game> findAllGames(){

        return repository.findAll();
    }

    public  Game findAllGames(long id) throws GameNotFoundException {
        return repository.findById(id).orElseThrow(GameNotFoundException::new);
    }


    public void addNewGameTitle(Game game){
        if(repository.findAll().stream().anyMatch(a->a.getTitle().equals(game.getTitle()))){
          return;
        }
        repository.save(game);
    }
}

package com.example.Services;
import com.example.Models.Game;
import com.example.Models.GameGenre;
import com.example.Repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GameService implements GameServiceInterface {
    GameRepository repository;
    public GameService(GameRepository rep)
    {
        repository=rep;
       /* repository.save(new Game(null,"Doom", GameGenre.FPS,"2016","The HellSlayer","\\img\\doom.png"));
        repository.save(new Game(null,"Minecraft",GameGenre.SandBox,"2011","BestGame","\\img\\minecraft.png"));
        repository.save(new Game(null,"Assassin's creed",GameGenre.OpenWorld,"2021","desc","\\img\\assasin.png"));
*/
    }
    public List<Game> search(){

        return repository.findAll();
    }

    public  Game search(long id){
        return repository.findById(id).get();
    }
}

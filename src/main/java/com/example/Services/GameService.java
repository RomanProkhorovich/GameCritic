package com.example.Services;

import com.example.Models.Game;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class GameService {
    private List<Game> games=new LinkedList<>();
    {
        games.add(new Game("doom","shooter", "2016","the best shooter"));
        games.add(new Game("minecraft","ALL", "2011","the game"));
        games.add(new Game("Assassin's Creed","Action", "2020","OpenWorld"));
    }
    public List<Game> search(){
        return  games;
    }
}

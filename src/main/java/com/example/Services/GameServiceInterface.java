package com.example.Services;

import com.example.Models.Game;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameServiceInterface {
    public List<Game> search();
    public  Game search(long id);
}

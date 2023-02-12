package com.example.Config;

import com.example.Models.Game;
import com.example.Models.Genre;
import com.example.Repository.GameRepository;
import com.example.Repository.GenreRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public ApplicationRunner genreLoader(GenreRepository repo){
        return args -> {
            repo.save(new Genre(null,"RPG"));
            repo.save(new Genre(null,"Открытый мир"));
            repo.save(new Genre(null,"Файтинг"));
            repo.save(new Genre(null,"Souls-like"));
            repo.save(new Genre(null,"Песочница"));
            repo.save(new Genre(null,"Шутер от первого лица"));
        };
    }
    @Bean
    public CommandLineRunner gameLoader(GameRepository repo,GenreRepository repos){
        return args -> {
            repo.save(new Game(null,"Doom",
                    repos.findGenreByName("Шутер от первого лица"),
                    LocalDate.of(2016, 5,13),
                    "Один из лучших шутеров 21-го века!",
                    "\\img\\doom.png"));
            repo.save(new Game(null,
                    "Assassin's creed: Valhalla",
                    repos.findGenreByName("Открытый мир"),
                    LocalDate.of(2020, 11,10),
                    "Один из самых красивых открытых миров!",
                    "\\img\\assasin.png"));
            repo.save(new Game(null,
                    "Minecraft",
                    repos.findGenreByName("Песочница"),
                    LocalDate.of(2011, 11,18),
                    "Игра, в которой можно делать все, что хочешь!",
                    "\\img\\minecraft.png"));
        };
    }
}

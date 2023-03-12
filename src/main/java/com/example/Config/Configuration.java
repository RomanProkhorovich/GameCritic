package com.example.Config;

import com.example.Models.*;
import com.example.Repository.*;
import com.example.Services.Impl.GameService;
import com.example.Services.Interface.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    @Transactional
    public ApplicationRunner genreLoader(@Qualifier("GenreServiceInterface") GenreServiceInterface repo){
        return args -> {
            repo.save(new Genre("RPG"));
            repo.save(new Genre("Открытый мир"));
            repo.save(new Genre("Файтинг"));
            repo.save(new Genre("Souls-like"));
            repo.save(new Genre("Песочница"));
            repo.save(new Genre("Шутер от первого лица"));
        };
    }
    @Bean
    @Transactional
    public CommandLineRunner UserLoader(@Qualifier("UserServiceInterface") UserServiceInterface repo){
        return args -> {
            repo.save(new User("Roma"));
            repo.save(new User("Vika"));
            repo.save(new User("Kostya"));
        };
    }

   @Bean
   @Transactional
    public CommandLineRunner gameLoader(@Qualifier("GameServiceInterface") GameServiceInterface repo
           , @Qualifier("GenreServiceInterface") GenreServiceInterface repos) {
        return args-> {
            repo.save(
                    new Game("Doom"
                            ,Set.of(repos.findGenreByName("Шутер от первого лица").orElse(new Genre("Шутер от первого лица")))
                            , LocalDate.of(2016, 5, 13)));
            repo.save(new Game("Assassin's creed: Valhalla",
                   Set.of(repos.findGenreByName("Открытый мир").orElse(new Genre("Открытый мир")))
                    ,LocalDate.of(2020, 11,10)));
            repo.save(new Game("Minecraft",
                  Set.of(repos.findGenreByName("Песочница").orElse(new Genre("Песочница"))),
                    LocalDate.of(2011, 11,18)));
        };
    }

    @Bean
    @Transactional
    public  CommandLineRunner commentsLoader(@Qualifier("CommentServiceInterface") CommentServiceInterface repo
            , @Qualifier("UserServiceInterface") UserServiceInterface users){
        return args -> {
            repo.save(new Comment(users.findByName("Roma").get(),"nrav"));
        };
    }
    @Bean
    @Transactional
    public  CommandLineRunner reviewLoader(@Qualifier("ReviewServiceInterface") ReviewServiceInterface repo
            ,@Qualifier("GameServiceInterface") GameServiceInterface gamerepo
            ,@Qualifier("CommentServiceInterface") CommentServiceInterface commens
            ,@Qualifier("UserServiceInterface") UserServiceInterface users){

        Game g=gamerepo.findGameByTitle("Doom").orElse(gamerepo.save(new Game("Doom"
                ,Set.of(new Genre("Шутер от первого лица"))
                , LocalDate.of(2016, 5, 13))));
        var re=Review.builder()
                .game(g)
                .about("Дед всех разъебал")
                .description("Мой любимый шутер")
                .comments((commens.findAllByUser(users.findByName("Roma").orElse(null))))
                .build();
        return args->{
            repo.save(re);
        };
    }
}

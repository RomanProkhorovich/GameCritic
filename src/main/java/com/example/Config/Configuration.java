package com.example.Config;

import com.example.Models.*;
import com.example.Models.User.Role;
import com.example.Models.User.Status;
import com.example.Models.User.User;
import com.example.Services.Interface.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.Set;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    @Transactional
    public ApplicationRunner genreLoader(@Qualifier("GenreServiceInterface") GenreServiceInterface repo) {
        return args -> {
            repo.save(new Genre("RPG"));
            repo.save(new Genre("Открытый мир"));
            repo.save(new Genre("Файтинг"));
            repo.save(new Genre("Souls-like"));
            repo.save(new Genre("Песочница"));
            repo.save(new Genre("Шутер от первого лица"));
            repo.save(new Genre("Rouge-like"));
            repo.save(new Genre("Action"));
        };
    }

    @Bean

    public ApplicationRunner PublisherLoader(@Qualifier("PublisherServiceInterface") PublisherServiceInterface repo) {
        return args -> {

        };
    }

    @Bean
    @Transactional
    public CommandLineRunner UserLoader(@Qualifier("UserServiceInterface") UserServiceInterface repo) {
        return args -> {
            repo.save(User.builder()
                    .nickname("Roma")
                    .role(Role.ADMIN)
                    .password((new BCryptPasswordEncoder(12)).encode("1915=jnj"))
                    .active(Status.ACTIVE)
                    .favoriteGames(Set.of(Game.builder()
                            .title("Doom")
                            .genres(Set.of(new Genre("Шутер от первого лица")))
                            .releaseDate(LocalDate.of(2016, 5, 13))
                            .rating((byte) 95)
                            .build())).build()
            );
        };
    }

    @Bean
    @Transactional
    public CommandLineRunner gameLoader(@Qualifier("GameServiceInterface") GameServiceInterface repo) {
        return args -> {
            repo.save(
                    Game.builder()
                            .title("Doom")
                            .genres(Set.of(new Genre("Шутер от первого лица")))
                            .releaseDate(LocalDate.of(2016, 5, 13))
                            .rating((byte) 95)
                            .build());
            repo.save(
                    Game.builder().title("Assassin's creed: Valhalla")
                            .genres(Set.of(new Genre("Открытый мир")))
                            .releaseDate(LocalDate.of(2020, 11, 10))
                            .rating((byte) 60)
                            .build());
            repo.save(
                    Game.builder()
                            .title("Minecraft")
                            .genres(Set.of(new Genre("Песочница")))
                            .releaseDate(LocalDate.of(2011, 11, 18))
                            .rating((byte) 90)
                            .build());
            repo.save(
                    Game.builder()
                            .title("Grand Theft Auto: San Andreas")
                            .genres(Set.of(new Genre("Открытый мир"), new Genre("Песочница")))
                            .releaseDate(LocalDate.of(2006, Month.OCTOBER, 26))
                            .rating((byte) 93)
                            .build());
            repo.save(
                    Game.builder()
                            .title("God of War")
                            .rating((byte) 90)
                            .releaseDate(LocalDate.of(2018, Month.APRIL, 20))
                            .genres(Set.of(new Genre("Action"), new Genre("RPG")))
                            .build());
        };
    }

    @Bean
    @Transactional
    public CommandLineRunner commentsLoader(@Qualifier("CommentServiceInterface") CommentServiceInterface repo) {
        return args -> {
            repo.save(new Comment(User.builder().nickname("Roma").build(), "nrav"));
        };
    }

    @Bean
    @Transactional
    public CommandLineRunner reviewLoader(@Qualifier("ReviewServiceInterface") ReviewServiceInterface repo
            , @Qualifier("GameServiceInterface") GameServiceInterface gamerepo
            , @Qualifier("CommentServiceInterface") CommentServiceInterface commens
            , @Qualifier("UserServiceInterface") UserServiceInterface users) {

        Game g = gamerepo.findGameByTitle("Doom").orElse(gamerepo.save(Game
                .builder()
                .title("Doom")
                .genres(Set.of(new Genre("Шутер от первого лица")))
                .releaseDate(LocalDate.of(2016, 5, 13))
                .rating((byte) 95)
                .build()));
        var re = Review.builder()
                .game(g)
                .about("Дед всех разъебал")
                .description("Мой любимый шутер")
                .comments((commens.findAllByUser(users.findByName("Roma").orElse(null))))
                .build();
        return args -> {
            repo.save(re);
        };
    }
}

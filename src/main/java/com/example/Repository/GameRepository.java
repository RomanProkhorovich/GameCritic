package com.example.Repository;

import com.example.Models.Game;
import com.example.Models.GameGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface GameRepository extends JpaRepository<Game,Long> {
    List<Game> findGamesByGenreOrderByReleaseDate(GameGenre genre);
}

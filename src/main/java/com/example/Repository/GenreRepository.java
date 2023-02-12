package com.example.Repository;

import com.example.Models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Long> {
        public Genre findGenreByName(String name);

}

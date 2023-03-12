package com.example.Models;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String title;
    @ManyToMany()
    @Cascade({ org.hibernate.annotations.CascadeType.MERGE})

    @JoinTable(
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id"))
    private Set<Genre> genres;
    private LocalDate releaseDate;

    public Game(String title, Set<Genre> genre, LocalDate releaseDate) {
        this.title = title;
        this.genres = genre;
        this.releaseDate = releaseDate;
    }


    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

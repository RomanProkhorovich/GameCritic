package com.example.Models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@NoArgsConstructor()
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String title;
    @ManyToOne()
    @JoinColumn(name = "genre_id")
    private Genre genre;
    private LocalDate releaseDate;

    public Game(String title, Genre genre, LocalDate releaseDate) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Game game = (Game) o;
        return Id != null && Objects.equals(Id, game.Id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

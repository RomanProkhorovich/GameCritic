package com.example.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor()
@Entity
@Data

public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String title;
    @ManyToOne()
    @JoinColumn(name = "genre_id")
    private Genre genre;
    private LocalDate releaseDate;
    private String description;
    @Nullable
    private String imgPath;

}

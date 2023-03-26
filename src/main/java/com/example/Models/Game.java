package com.example.Models;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.junit.jupiter.params.converter.ArgumentConversionException;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String title;
    @ManyToMany()
    @Cascade({org.hibernate.annotations.CascadeType.MERGE})

    @JoinTable(
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id"))
    private Set<Genre> genres;
    private LocalDate releaseDate;
    @Transient
    private SystemRequirements min;
    @Transient
    private SystemRequirements recommendation;
   /* @ManyToOne
    private Publisher publisher;
    @ManyToMany
    private Set<Developer> developers;*/
    private byte rating;

    public void setRating(byte value) {
        if (value <= 0 || value > 100) {
            throw new ArgumentConversionException("rating should be between 0 and 100");
        }
        rating = value;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

package com.example.Models;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
//@Setter
@RequiredArgsConstructor
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

  /*  @ManyToMany()
    @Cascade({ org.hibernate.annotations.CascadeType.MERGE})
    private Set<Game> games;*/

    public Genre(String name) {
        this.name = name;
    }

    @Override
    public String toString() {return name;}


    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

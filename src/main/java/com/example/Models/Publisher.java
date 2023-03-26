package com.example.Models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private Set<Game> games;

    public Publisher(String name, Set<Game> games) {
        this.name = name;
        this.games = games;
    }
}

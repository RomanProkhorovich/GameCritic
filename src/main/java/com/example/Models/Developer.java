package com.example.Models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    @JoinTable(
            joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    private Set<Game> games;

}

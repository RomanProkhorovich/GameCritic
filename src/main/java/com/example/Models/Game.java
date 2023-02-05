package com.example.Models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor()
@Entity
@Table

public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private Long Id;
    private String title;
    private GameGenre genre;
    private Date releaseDate;
    private String description;
    @Nullable
    private String imgPath;




    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String d){
        this.description=d;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String t){
        title=t;
    }

    public String getGenre() {
        return genre.getTitle();
    }

    public void setGenre(String genre) {
        this.genre = GameGenre.valueOf(genre);
    }

    @Nullable
    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(@Nullable String imgPath) {
        this.imgPath = imgPath;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}

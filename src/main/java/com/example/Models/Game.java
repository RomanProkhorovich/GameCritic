package com.example.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor

public class Game {
    private String title;
    private String genre;
    private String release;
    private String description;
}

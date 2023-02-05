package com.example.Models;

public enum GameGenre {
    RPG("Ролевая игра"),
    FPS("Шутер от первого лица"),
    SandBox("Песочница"),
    OpenWorld("Открытый мир");
    private  String title;

    GameGenre(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}

package com.example.Services.Impl;

import com.example.Models.Game;
import com.example.Models.User.User;
import com.example.Repository.UserRepository;
import com.example.Services.Interface.GameServiceInterface;
import com.example.Services.Interface.UserServiceInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Qualifier("UserServiceInterface")
public class UserService implements UserServiceInterface {
    private final UserRepository repo;
    private final GameServiceInterface games;

    public UserService(UserRepository repo, @Qualifier("GameServiceInterface") GameServiceInterface games) {
        this.repo = repo;
        this.games = games;
    }

    public Optional<User> findByName(String name) {
        return repo.findByNickname(name);
    }

    @Override
    public User save(User user) {
        if (user==null)
            return null;
        Set<Game> gameSet = new HashSet<>();

        if (user.getFavoriteGames()!=null) {
            for (var game : user.getFavoriteGames()) {
                gameSet.add(games.save((Game) game));
            }
            user.setFavoriteGames(gameSet);
        }


        if (findByName(user.getNickname()).isEmpty()) {
            return repo.save(user);
        }
        return findByName(user.getNickname()).get();
    }
}

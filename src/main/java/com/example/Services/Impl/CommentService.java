package com.example.Services.Impl;

import com.example.Models.Comment;
import com.example.Models.User.User;
import com.example.Repository.CommentsRepository;
import com.example.Services.Interface.CommentServiceInterface;
import com.example.Services.Interface.UserServiceInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("CommentServiceInterface")
public class CommentService implements CommentServiceInterface {
    private final CommentsRepository repo;
    private final UserServiceInterface users;

    public CommentService(CommentsRepository repo, @Qualifier("UserServiceInterface") UserServiceInterface users) {
        this.repo = repo;
        this.users = users;
    }

    @Override
    public List<Comment> findAllByUser(User user) {
        return repo.findAllByUser(user);
    }

    @Override
    public List<Comment> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Comment> findByText(String text) {
        return repo.findByText(text);
    }


    //@Transactional(readOnly = true)
    @Override
    public Comment save(Comment com) {
        if (com == null)
            return null;
        com.setUser(users.save(com.getUser()));

        if (findByText(com.getText()).isEmpty()) {
            return repo.save(com);
        }
        return findByText(com.getText()).get();
    }
}

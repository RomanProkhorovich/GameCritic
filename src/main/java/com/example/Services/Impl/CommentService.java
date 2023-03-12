package com.example.Services.Impl;

import com.example.Models.Comment;
import com.example.Models.User;
import com.example.Repository.CommentsRepository;
import com.example.Services.Interface.CommentServiceInterface;
import com.example.Services.Interface.UserServiceInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Comment save(Comment com) {

        //users.save(com.getUser());
        return repo.save(com);
    }
}

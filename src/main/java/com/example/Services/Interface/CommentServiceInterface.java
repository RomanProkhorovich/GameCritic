package com.example.Services.Interface;

import com.example.Models.Comment;
import com.example.Models.User.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CommentServiceInterface {
    List<Comment> findAllByUser(User user);
    List<Comment> findAll();
    Optional<Comment> findByText(String text);
    Comment save(Comment com);
}

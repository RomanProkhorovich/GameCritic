package com.example.Services.Interface;

import com.example.Models.Comment;
import com.example.Models.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentServiceInterface {
    List<Comment> findAllByUser(User user);
    List<Comment> findAll();

    Comment save(Comment com);
}

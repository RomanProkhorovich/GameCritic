package com.example.Repository;

import com.example.Models.Comment;
import com.example.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment,Long> {
    List<Comment> findAllByUser(User user);
}

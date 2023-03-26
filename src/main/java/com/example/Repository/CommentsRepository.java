package com.example.Repository;

import com.example.Models.Comment;
import com.example.Models.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentsRepository extends JpaRepository<Comment,Long> {
    List<Comment> findAllByUser(User user);


    Optional<Comment> findByText(String text);
}

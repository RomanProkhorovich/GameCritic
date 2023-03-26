package com.example.Services.Interface;

import com.example.Models.Publisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PublisherServiceInterface {
    Optional<Publisher> findById(Long id);
    Optional<Publisher> findByName(String name);
    Publisher save(Publisher publisher);

}

package com.example.Services.Impl;
import com.example.Models.Publisher;
import com.example.Repository.PublisherRepository;
import com.example.Services.Interface.PublisherServiceInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Qualifier("PublisherServiceInterface")
public class PublisherService implements PublisherServiceInterface {
    private final PublisherRepository repo;

    public PublisherService(PublisherRepository repo) {
        this.repo = repo;
    }

    @Override
    public Optional<Publisher> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Optional<Publisher> findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public Publisher save(Publisher publisher) {
        if (publisher==null)
            return null;
        if(repo.findByName(publisher.getName()).isEmpty()){
            return repo.save(publisher);
        }
        return repo.findByName(publisher.getName()).get();
    }
}

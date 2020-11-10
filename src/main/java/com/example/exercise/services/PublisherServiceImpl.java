package com.example.exercise.services;

import com.example.exercise.models.Publisher;
import com.example.exercise.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Optional<Publisher> getPublisherByName(String name) {
        return publisherRepository.getPublisherByName(name);
    }

}

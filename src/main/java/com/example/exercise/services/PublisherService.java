package com.example.exercise.services;

import com.example.exercise.models.Publisher;

import java.util.Optional;

public interface PublisherService {

    //Interaction with the repository
    Optional<Publisher> getPublisherByName(String name);

}

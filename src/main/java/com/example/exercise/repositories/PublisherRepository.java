package com.example.exercise.repositories;

import com.example.exercise.models.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {

    //interactions with DB

    Optional<Publisher> getPublisherByName(String name);

}

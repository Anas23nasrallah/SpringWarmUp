package com.example.exercise.controllers;

import com.example.exercise.models.Publisher;
import com.example.exercise.services.PublisherServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PublisherController {

    private final PublisherServiceImpl publisherService;

    public PublisherController(PublisherServiceImpl publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/publisher/{name}")
    @ResponseBody
    public Publisher getPublisherByName(@PathVariable String name){
        return publisherService.getPublisherByName(name).get();
    }

}

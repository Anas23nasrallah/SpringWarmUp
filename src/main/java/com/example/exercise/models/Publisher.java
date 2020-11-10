package com.example.exercise.models;

import javax.persistence.*;

@Entity
//@Table(name="trc.publishers",
//        uniqueConstraints = {@UniqueConstraint(columnNames={"id", "name"})}
//)
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //more fields


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

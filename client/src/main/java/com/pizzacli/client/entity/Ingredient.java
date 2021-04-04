package com.pizzacli.client.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.bind.Name;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @NotNull(message = "id should not be empty")
    @Column(name="id")
    private int id;

    @Column(name="name")
    String name;

    public Ingredient(){

    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Ingredient(String name) {
        this.name = name;
    }

    

}

package com.pizzacli.client.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "pizzas")
@Entity
public class Pizza {

    @Column
    @NotNull(message = "Pizza Name should not be empty")
    private String name;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @NotNull(message = "orderId should not be empty")
    @Column
    private int orderId;
    @Column
    @NotNull(message = "the pizza should have at leats three ingredients")
    @OneToMany(cascade=CascadeType.ALL)
    private List<Ingredient> Ingredients;

    public Pizza(String name, int orderId, List<Ingredient> ingredients) {
        this.name = name;
        this.orderId = orderId;
        Ingredients = ingredients;
    }

    public Pizza(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Ingredient> getIngredients() {
        return Ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        Ingredients = ingredients;
    }
    

    
}

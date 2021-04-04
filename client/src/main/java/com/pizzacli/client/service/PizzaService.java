package com.pizzacli.client.service;

import java.util.List;
import java.util.Optional;

import com.pizzacli.client.entity.Pizza;
import com.pizzacli.client.repository.PizzaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Pizza> getPizzas(){
        System.out.println("******************************** service");


        List<Pizza> pizzas =         pizzaRepository.findAll();
        System.out.println("out of the repository");
        return pizzas;
    }


    public Optional<Pizza> getPizzaById(int id){
        Optional<Pizza> pizza = pizzaRepository.findById(id);

        return pizza;
    }

    public Pizza addPizza(Pizza pizza){
        pizzaRepository.save(pizza);
        return pizza;
    }

    public Pizza modifyPizza(int id, Pizza pizza){
        Pizza originalPizza = pizzaRepository.getById(id);
        originalPizza.setName(pizza.getName());
        originalPizza.setIngredients(pizza.getIngredients());
        

        return originalPizza;
    }
}

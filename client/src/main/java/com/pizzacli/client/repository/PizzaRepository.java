package com.pizzacli.client.repository;

import com.pizzacli.client.entity.Pizza;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
    
}

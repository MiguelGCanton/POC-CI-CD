package com.pizzacli.client.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import com.pizzacli.client.entity.Pizza;
import com.pizzacli.client.repository.PizzaRepository;
import com.pizzacli.client.service.PizzaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    PizzaService pizzaService;
    
    @Value("${app.store.code}")
    private String storeCode;

    @PostMapping(value ="")
    public ResponseEntity<Message> orderPizza(@RequestBody @Valid Pizza pizza ){
        pizzaService.addPizza(pizza);
        return  new ResponseEntity<Message>(new Message("order taken in change" + this.storeCode), HttpStatus.ACCEPTED);

    }

    @GetMapping(value ="{id}")
    public ResponseEntity<Message> getPizzaById(@PathVariable("id") int id ){
        Optional<Pizza> pizza = pizzaService.getPizzaById(id);

        if(pizza.isPresent()) {
            return  new ResponseEntity<Message>(new Message("order taken in" + this.storeCode), HttpStatus.OK);
        }else{
            return  new ResponseEntity<Message>(new Message("pizza not found" + this.storeCode), HttpStatus.NOT_FOUND);
        }
        
    }

    @GetMapping(value ="")
    public ResponseEntity<List<Pizza>> allPizzas(){
        System.out.println("**************************** in");
        return new ResponseEntity<List<Pizza>>(pizzaService.getPizzas(), HttpStatus.OK);
        
    }
    


    private class Message{
        private String message;

        public Message(String message){
            this.message = message;
        }

        public String getMessage(){
            return this.message;
        }
    }

}

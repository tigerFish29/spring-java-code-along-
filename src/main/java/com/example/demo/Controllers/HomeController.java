package com.example.demo.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private List<HomeController> people = new ArrayList<>();

    @GetMapping("/test")
    public String test() {
        return "Hello world";
    }

    // create a person 
    @PostMapping("/create")
    public boolean addPerson(@RequestBody HomeController person) {
        return this.people.add(person);
    }

    // Read 
    @GetMapping("/getAll")
    public List<HomeController> getAll() {
        return this.people;
    }

    // updating the person 
    @PutMapping("/update")
    public HomeController updatePerson(@PathParam("id") int id, @RequestBody HomeController person) {
        // removing existing person with matching id 
        this.people.remove(id);
        // add new person in its place 
        this.people.add(id, person);
        // return updated person 
        return this.people.get(id);
    }
    
    // deleting people 
    @DeleteMapping("/delete/{id}")
    public HomeController removePerson(@PathVariable int id) {
        return this.people.remove(id);
    }
}

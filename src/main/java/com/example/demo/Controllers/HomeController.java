package com.example.demo.Controllers;

import java.util.List;
import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.PersonService;

@RestController
public class HomeController {

    private PersonService service;

    public HomeController(PersonService service) {
        super();
        this.service = service;
    }

    @GetMapping("/test")
    public String test() {
        return "Hello world";
    }

    // create a person 
    @PostMapping("/create")
    public HomeController addPerson(@RequestBody HomeController person) {
        return this.service.addPerson(person);
    }

    // Read 
    @GetMapping("/getAll")
    public List<HomeController> getAllPeople() {
        return this.service.getAllPeople();
    }

    // updating the person 
    @PutMapping("/update")
    public HomeController updatePerson(@PathParam("id") int id, @RequestBody HomeController person) {
        return this.service.updatePerson(id, person);
    }
    
    // deleting people 
    @DeleteMapping("/delete/{id}")
    public HomeController removePerson(@PathVariable int id) {
        return this.service.removePerson(id);
    }
}

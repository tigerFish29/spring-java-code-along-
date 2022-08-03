package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Controllers.HomeController;

public class PersonService {
    
    private List<HomeController> people = new ArrayList<>();

    public HomeController addPerson(HomeController person) {
        // add the person 
        this.people.add(person);
        // return the last added person from the list 
        return this.people.get(this.people.size() -1 );
    }

    // return the all list 
    public List<HomeController> getAllPeople() {
        return this.people;
    }

    // updating the person 
    public HomeController updatePerson(int id, HomeController person) {
        // remove exisitng person with matching id 
        this.people.remove(id);
        // add new person in its place 
        this.people.add(id, person);
        // return updated person from the list 
        return this.people.get(id);
    }

    // removing the person 
    public HomeController removePerson(int id) {
        // remove the person and return 
        return this.people.remove(id);
    }
}

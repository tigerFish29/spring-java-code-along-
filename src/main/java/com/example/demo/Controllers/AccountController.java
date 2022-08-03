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
public class AccountController {

    private List<AccountController> accounts = new ArrayList<>();

   /* 
       CRUD OPERATIONS
   */ 
  // create
    @PostMapping("/createAccount")
    public boolean addAccount(@RequestBody AccountController accounts) {
        return this.accounts.add(accounts);
    }

    // get all accounts
    @GetMapping("/getAccounts")
    public List<AccountController> getAll() {
        return this.accounts;
    }

    // updating the accounts 
    @PutMapping("/update")
    public AccountController updateAccount(@PathParam("id") int id, @RequestBody AccountController accounts) {
        this.accounts.remove(id);
        this.accounts.add(id, accounts);
        return this.accounts.get(id);
    }

    // deleting accounts 
    @DeleteMapping("/delete/{id}")
    public AccountController removeAccounts(@PathVariable int id) {
        return this.accounts.remove(id);
    }
    
}

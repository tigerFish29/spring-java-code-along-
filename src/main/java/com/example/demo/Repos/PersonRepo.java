package com.example.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Controllers.HomeController;

@Repository
public interface PersonRepo extends JpaRepository<HomeController, Long> {

}
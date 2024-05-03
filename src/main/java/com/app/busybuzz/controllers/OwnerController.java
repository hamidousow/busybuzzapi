package com.app.busybuzz.controllers;

import com.app.busybuzz.models.Owner;
import jakarta.persistence.Entity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/busybuzz")
public class OwnerController {

    @GetMapping("/createowner")
    public ResponseEntity<String> createAccount() {
        Owner owner = new Owner("test", "lastname", "email@gmail.com");
        System.out.println(owner.toString());
        return ResponseEntity.ok("Hello owner");
    }

}

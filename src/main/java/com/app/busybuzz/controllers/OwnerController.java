package com.app.busybuzz.controllers;

import com.app.busybuzz.models.Owner;
import com.app.busybuzz.services.IOwnerService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/busybuzz")
public class OwnerController {

    @Autowired
    IOwnerService ownerService;

    @GetMapping("/create-owner")
    public ResponseEntity<String> createAccount(
            @RequestParam("name") String name,
            @RequestParam("lastname") String lastname,
            @RequestParam("mail") String mail
    ) {
        Owner owner = new Owner(name, lastname, mail);
        ownerService.create(owner);
        Optional<Owner> ownerFind = ownerService.findOneById(owner.getId());
        if(ownerFind.isEmpty()) {
            return ResponseEntity.ok("Fail subscription.");
        }
        return ResponseEntity.ok("User created successful");
    }

}

package com.example.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Gokulesh;
import com.example.springapp.service.GokuleshService;

@RestController
public class GokuleshController {
    public GokuleshService GokuleshService;

    public PersonController(GokuleshService personService) {
        this.GokuleshService = personService;
    }

    @PostMapping("/api/person")
    public ResponseEntity<Gokulesh> postMethodName(@RequestBody Gokulesh person) {
        if (GokuleshService.savePerson(person)) {
            return new ResponseEntity<>(person, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/person/byage/{age}")
    public ResponseEntity<List<Gokulesh>> getMethodName(@PathVariable("age") int age) {
        List<Gokulesh> list = GokuleshService.getPersonByAge(age);
        if (list.size() == 0) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}

package com.examly.class_exercise_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examly.class_exercise_1.model.Gokulesh;
import com.examly.class_exercise_1.service.GokuleshService;

@RestController
public class GokuleshController {

     @Autowired
     public GokuleshService GokuleshService;

     @PostMapping("/api/person")
     public ResponseEntity<Gokulesh> postMethodName(@RequestBody Gokulesh entity) {

          Gokulesh inst = GokuleshService.SaveEntity(entity);

          return new ResponseEntity<Gokulesh>(inst, HttpStatus.CREATED);

     }

     @GetMapping("/api/person")
     public ResponseEntity<List<Gokulesh>> getMethodName() {

          List<Gokulesh> show = GokuleshService.getDetails();
          if (!show.isEmpty()) {
               return new ResponseEntity<List<Gokulesh>>(show, HttpStatus.OK);
          } else {
               return new ResponseEntity<List<Gokulesh>>(show, HttpStatus.NOT_FOUND);
          }
     }

     @GetMapping("api/person/byAge")
     public List<Gokulesh> custom(@RequestParam int byAge) {
          return GokuleshService.findByAge(byAge);

     }
}
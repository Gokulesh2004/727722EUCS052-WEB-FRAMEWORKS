package com.example.class_exercise_2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.class_exercise_2.model.Gokulesh;
import com.example.class_exercise_2.service.GokuleshService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class GokuleshController {

     @Autowired
     public GokuleshService   GokuleshService;

     @GetMapping("/api/student")
     public ResponseEntity<List<Gokulesh>> getDetails() {
          List<Gokulesh> list = GokuleshService.getAll();
          if (list.isEmpty()) {
               return new ResponseEntity<List<Gokulesh>>(list, HttpStatus.NOT_FOUND);
          }
          return new ResponseEntity<List<Gokulesh>>(list, HttpStatus.OK);

     }

     @PostMapping("/api/student")
     public ResponseEntity<Gokulesh> postMethodName(@RequestBody Gokulesh student) {

          Gokulesh postData = GokuleshService.post(student);
          return new ResponseEntity<>(postData, HttpStatus.OK);
     }

     @GetMapping("/api/student/sort/{field}")
     public ResponseEntity<List<Gokulesh>> sortedDetails(@PathVariable String field) {
          List<Gokulesh> list = GokuleshService.sortedDetails(field);
          if (list.isEmpty()) {
               return new ResponseEntity<List<Gokulesh>>(list, HttpStatus.NOT_FOUND);
          }
          return new ResponseEntity<List<Gokulesh>>(list, HttpStatus.OK);

     }
}

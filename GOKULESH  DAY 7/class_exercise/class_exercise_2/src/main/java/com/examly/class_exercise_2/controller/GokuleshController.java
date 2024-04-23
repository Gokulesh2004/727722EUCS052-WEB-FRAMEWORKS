package com.examly.class_exercise_2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.examly.class_exercise_2.model.Gokulesh;
import com.examly.class_exercise_2.service.GokuleshService;

@RestController
public class GokuleshController {

     @Autowired
     public GokuleshService GokuleshService;

     @PostMapping("/api/course")
     public ResponseEntity<Gokulesh> postMethodName(@RequestBody Gokulesh entity) {

          Gokulesh inst = GokuleshService.SaveEntity(entity);

          return new ResponseEntity<Gokulesh>(inst, HttpStatus.CREATED);

     }

     @GetMapping("/api/course")
     public ResponseEntity<List<Gokulesh>> getMethodName() {

          List<Gokulesh> show = GokuleshService.getDetails();
          if (!show.isEmpty()) {
               return new ResponseEntity<List<Gokulesh>>(show, HttpStatus.OK);
          } else {
               return new ResponseEntity<List<Gokulesh>>(show, HttpStatus.NOT_FOUND);
          }
     }

     @GetMapping("api/course/{courseName}")
     public List<Gokulesh> custom(@PathVariable String courseName) {
          return GokuleshService.findByCourseName(courseName);

     }
}
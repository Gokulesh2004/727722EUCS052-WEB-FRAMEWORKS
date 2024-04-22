package com.example.class_exercise_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.class_exercise_1.model.Gokulesh;
import com.example.class_exercise_1.service.GokuleshService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class GokuleshController {

     @Autowired
     public GokuleshService GokuleshService;

     @GetMapping("/api/children/sortBy/{babyFirstName}")
     public ResponseEntity<List<Gokulesh>> sort(@PathVariable String babyFirstName) {
          List<Gokulesh> child = GokuleshService.sort(babyFirstName);

          if (child.isEmpty()) {

               return new ResponseEntity<>(child, HttpStatus.NOT_FOUND);
          }
          return new ResponseEntity<>(child, HttpStatus.OK);

     }

     // Pagination
     @GetMapping("api/children/{offset}/{pagesize}")
     public ResponseEntity<List<Gokulesh>> pagination(@PathVariable int offset, @PathVariable int pagesize) {
          List<Gokulesh> pages = GokuleshService.pagination(offset, pagesize);
          if (pages.isEmpty()) {
               return new ResponseEntity<List<Gokulesh>>(pages, HttpStatus.NOT_FOUND);
          }
          return new ResponseEntity<List<Gokulesh>>(pages, HttpStatus.OK);
     }

     @GetMapping("/api/children/{offset}/{pagesize}/{field}")
     public ResponseEntity<List<Gokulesh>> sortedPage(@PathVariable int offset, @PathVariable int pagesize,
               @PathVariable String field) {
          List<Gokulesh> sortedPage =GokuleshService.sortedPage(offset, pagesize, field);
          if (sortedPage.isEmpty()) {

               return new ResponseEntity<>(sortedPage, HttpStatus.NOT_FOUND);
          }
          return new ResponseEntity<>(sortedPage, HttpStatus.OK);
     }

     @PostMapping("/api/children")
     public ResponseEntity<Gokulesh> postDetails(@RequestBody Gokulesh children) {

          return new ResponseEntity<Gokulesh>(GokuleshService.save(children), HttpStatus.CREATED);
     }

}
package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.examly.springapp.model.Gokulesh;
import com.examly.springapp.service.GokuleshService;

@RestController
public class GokuleshController {
    @Autowired
    private GokuleshService GokuleshService;

    @PostMapping("/Student")
    public ResponseEntity<Gokulesh> post(@RequestBody Gokulesh student) {
        if (GokuleshService.post(Gokulesh)) {
            return new ResponseEntity<>(Gokulesh, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/Student/marksGreaterThan/{mark}")
    public ResponseEntity<List<Gokulesh>> getAll(@PathVariable int mark) {
        List<Gokulesh> li = GokuleshService.start(mark);
        if (li.size() > 0) {
            return new ResponseEntity<>(li, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/Student/marksLessThan/{mark}")
    public ResponseEntity<List<Gokulesh>> getbyAge(@PathVariable int mark) {
        List<Gokulesh> li = GokuleshService.end(mark);
        if (li.size() > 0) {
            return new ResponseEntity<>(li, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

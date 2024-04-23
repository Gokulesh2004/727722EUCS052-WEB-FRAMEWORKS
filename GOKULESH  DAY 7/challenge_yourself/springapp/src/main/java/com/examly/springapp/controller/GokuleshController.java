package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.examly.springapp.model.Gokulesh;
import com.examly.springapp.service.GokuleshService;

@RestController
public class GokuleshController {
    @Autowired
    GokuleshService service;

    @PostMapping("/api/Product")
    public ResponseEntity<Gokulesh> postMethod(@RequestBody Gokulesh s) {
        if (service.post(s)) {
            return new ResponseEntity<Gokulesh>(s, HttpStatus.CREATED);
        } else {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/product")
    public ResponseEntity<List<Gokulesh>> dndcjk() {
        List<Gokulesh> page = service.getAll();
        if (!page.isEmpty()) {
            return new ResponseEntity<List<Gokulesh>>(page, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/api/product/category/{productCategory}")
    public ResponseEntity<List<Gokulesh>> getbyid(@PathVariable String productCategory) {
        List<Gokulesh> p = service.getProduct(productCategory);
        if (!p.isEmpty()) {
            return new ResponseEntity<List<Gokulesh>>(p, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }

    @GetMapping("/api/product/category/priceCategory/{priceCategory}")
    public ResponseEntity<List<Gokulesh>> getbdyid(@PathVariable String priceCategory) {
        List<Gokulesh> p = service.getProductbyprice(priceCategory);
        if (!p.isEmpty()) {
            return new ResponseEntity<List<Gokulesh>>(p, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }

}

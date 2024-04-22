package com.example.day5cw1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.day5cw1.model.Gokulesh;
import com.example.day5cw1.service.GokuleshService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class GokuleshController {
    public GokuleshService GokuleshService;
    public GokuleshController(GokuleshService productService)
    {
        this.GokuleshService = productService;
    }
    @PostMapping("/api/product")
    public ResponseEntity<Gokulesh> postMethodName(@RequestBody Gokulesh product) {
        if(GokuleshService.saveProduct(product) == true)
        {
            return new ResponseEntity<>(product,HttpStatus.CREATED);
        }
        
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/api/product/{productId}")
    public ResponseEntity<Gokulesh> putMethodName(@PathVariable("productId") int id, @RequestBody Gokulesh product) {
        if(GokuleshService.updateDetails(id,product) == true)
        {
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("api/product/{productId}")
    public ResponseEntity<Gokulesh> delete(@PathVariable("productId") int id,@RequestBody Gokulesh product)
    {
        if(GokuleshService.deleteProduct(id) == true)
        {
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}

package com.example.day5cw2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day5cw2.model.Gokulesh;
import com.example.day5cw2.service.GokuleshService;

@RestController
public class GokuleshController {
    public GokuleshService gokuleshService;
    public GokuleshController( GokuleshService employeeService)
    {
        this.gokuleshService=employeeService;
    }
    @PostMapping("/api/employee")
    public ResponseEntity<Gokulesh> postMethodName(@RequestBody Gokulesh employee) {
        if(gokuleshService.saveEmployee(employee) == true)
        {
            return new ResponseEntity<>(employee,HttpStatus.CREATED);
        }
        
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/api/employee/{employeeId}")
    public ResponseEntity<Gokulesh> putMethodName(@PathVariable("employeeId") int id, @RequestBody Gokulesh employee) {
        if(gokuleshService.updateDetails(id,employee) == true)
        {
            return new ResponseEntity<>(employee,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/api/employee/{employeeId}")
    public ResponseEntity<Gokulesh> delete(@PathVariable("employeeId") int id,@RequestBody Gokulesh employee)
    {
        if(gokuleshService.deleteEmployee(id) == true)
        {
            return new ResponseEntity<>(employee,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}

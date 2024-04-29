package com.example.ce1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ce1.model.EmployeeGokulesh;
import com.example.ce1.service.EmployeeGokuleshService;

@RestController
public class EmployeeGokuleshController {
    @Autowired
    EmployeeGokuleshService employeeService;

    @PostMapping("/employee")
    public EmployeeGokulesh setMethod(@RequestBody EmployeeGokulesh employee)
    {
        return employeeService.setEmployee(employee);
    }

    @GetMapping("/employees-inner-join")
    public List<EmployeeGokulesh> getInnerMethod()
    {
        return employeeService.getInnerEmployee();
    }

    @GetMapping("/employees-left-outer-join")
    public List<EmployeeGokulesh> getLeftMethod()
    {
        return employeeService.getLeftOuterEmployee();
    }
}

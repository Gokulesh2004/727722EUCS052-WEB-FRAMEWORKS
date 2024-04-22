package com.example.day6cy.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.day5cw1.model.Gokulesh;
import com.example.day6cy.model.Employee;
import com.example.day6cy.repository.EmployeeRepo;

@Service
public class GokuleshService {
    public GokuleshRepo GokuleshRepo;
    public GokuleshService(GokuleshRepo employeeRepo)
    {
        this.GokuleshRepo = employeeRepo;
    }
    public boolean postEmployee(Employee employee)
    {
        try{

            GokuleshRepo.save(employee);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<Gokulesh> sortEmployee(String field)
    {
        return GokuleshRepo.findAll(Sort.by(field));
    }
    public List<Gokulesh> paginationEmployee(int pageno,int size)
    {
        return GokuleshRepo.findAll(PageRequest.of(pageno, size)).getContent();
    }
    public List<Gokulesh>  sortPaginationEmployee(int pageno,int size,String field)
    {
        return GokuleshRepo.findAll(PageRequest.of(pageno, size,Sort.by(field))).getContent();
    }
}

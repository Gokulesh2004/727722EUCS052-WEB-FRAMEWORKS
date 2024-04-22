package com.example.day5cw2.service;

import org.springframework.stereotype.Service;

import com.example.day5cw2.model.Gokulesh;
import com.example.day5cw2.repository.GokuleshRepo;

@Service
public class GokuleshService {
    public EmployeeRepo GokuleshRepo;
    public GokuleshService(GokuleshRepo employeeRepo)
    {
        this.GokuleshRepo = employeeRepo;
    }
    public boolean saveEmployee(Gokulesh employee)
    {
        try
        {
            GokuleshRepo.save(employee);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean updateDetails(int id,Gokulesh employee)
    {
        if(this.getEmployeeById(id)==null)
        {
            return false;
        }
        try{
            employeeRepo.save(employee);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteEmployee(int id)
    {
        if(this.getEmployeeById(id) == null)
        {
            return false;
        }
        GokuleshRepo.deleteById(id);
        return true;
    }
    public Gokulesh getEmployeeById(int id)
    {
        return GokuleshRepo.findById(id).orElse(null);
    }
}

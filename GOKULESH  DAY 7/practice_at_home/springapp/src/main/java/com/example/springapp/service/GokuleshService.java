package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import com.examly.class_exercise_1.model.Gokulesh;
import com.example.springapp.model.Gokulesh;
import com.example.springapp.repository.GokuleshRepo;

@Service
public class GokuleshService {
    @Autowired
    private GokuleshRepo GokuleshRepo;

    public boolean post(  Gokulesh car)
    {
        try
        {
            GokuleshRepo.save(car);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public List<Gokulesh> getAll()
    {
        return GokuleshRepo.findAll();
    }

    public Car getByDetails(String currentOwnerName, String address)
    {
        try{
        return carRepo.findDistinctBycurrentOwnerNameAndAddress(currentOwnerName, address);
        }
        catch(IncorrectResultSizeDataAccessException i)
        {
            System.out.println("\n\n"+i+"\n\nUse List if needed");
            return null;
        }
        catch(Exception e)
        {
            System.out.println("\n\n"+e);
            return null;
        }
    }
    
}

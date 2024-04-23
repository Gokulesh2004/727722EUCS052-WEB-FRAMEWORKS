package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Gokulesh;
import com.example.springapp.repository.GokuleshRepo;

@Service
public class GokuleshService {
    @Autowired
    private GokuleshRepo rep;

    public boolean post(Gokulesh person)
    {
        try
        {
            rep.save(person);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public List<Gokulesh> start(String value)
    {
        return rep.findByNameStartingWith(value);
    }

    public List<Gokulesh> end(String value)
    {
        return rep.findByNameEndingWith(value);
    }
    
}

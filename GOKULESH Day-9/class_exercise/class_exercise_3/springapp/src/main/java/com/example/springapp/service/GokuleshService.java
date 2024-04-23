package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day5cw2.model.Gokulesh;
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

    public Gokulesh start(String lastname)
    {
        return rep.findByName(lastname);
    }
    public Gokulesh get3(int id)
    {
        return rep.findById(id);
    }

    public List<Gokulesh> end(int population)
    {
        return rep.findByPopulation(population);
    }
    
}

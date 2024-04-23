package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Gokulesh;
import com.example.springapp.repository.GokuleshRepo;

@Service
public class GokuleshService {
    @Autowired
    private GokuleshRepo rep;

    @SuppressWarnings("null")
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
        return rep.findByProductNameStartingWith(value);
    }

    public List<Gokulesh> end(String value)
    {
        return rep.findByProductNameEndingWith(value);
    }
    public List<Gokulesh> sort()
    {
        return rep.findAll(Sort.by("price"));
    }
    
}

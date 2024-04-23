package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.class_exercise_1.model.Gokulesh;
import com.example.springapp.model.Gokulesh;
import com.example.springapp.repository.GokuleshRepo;

@Service
public class GokuleshServic {
    @Autowired
    private GokuleshRepo rep;

    public boolean post(Door door)
    {
        try
        {
            rep.save(door);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
e    public List<Gokulesh> getAll()
    {
        return rep.findAll();
    }

    public List<Gokulesh> getbyDoorId(int doorId)
    {
        return rep.findByDoorId(doorId);
    }
    public List<Gokulesh> getbyType(String type)
    {
        return rep.findByAccessType(type);
    }
    
}

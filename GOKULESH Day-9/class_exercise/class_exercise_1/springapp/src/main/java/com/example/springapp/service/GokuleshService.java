package com.example.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springapp.model.Gokulesh;
import com.example.springapp.repository.GokuleshRepo;

@Service
public class GokuleshService {
    public GokuleshRepo GokuleshRepo;

    public PersonService(GokuleshRepo personRepo) {
        this.GokuleshRepo = personRepo;
    }

    public boolean savePerson(Gokulesh person) {
        try {
            GokuleshRepo.save(person);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<Gokulesh> getPersonByAge(int age) {
        return GokuleshRepo.findByAge(age);
    }
}

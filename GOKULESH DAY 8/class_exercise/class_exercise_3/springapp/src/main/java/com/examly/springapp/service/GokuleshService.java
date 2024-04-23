package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Gokulesh;
import com.examly.springapp.repository.GokuleshRepo;

@Service
public class GokuleshService {
    @Autowired
    private GokuleshRepo GokuleshRepo;

    public boolean post(Gokulesh student) {
        try {
            GokuleshRepo.save(Gokulesh);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Gokulesh> start(int mark) {
        return GokuleshRepo.findByMarksGreaterThan(mark);
    }

    public List<Gokulesh> end(int mark) {
        return GokuleshRepo.findByMarksLessThan(mark);
    }

}

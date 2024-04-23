package com.examly.springapp.service;

import com.examly.springapp.model.Gokulesh;
import com.examly.springapp.repository.GokuleshRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class GokuleshService {
    @Autowired
    GokuleshRepo repo;

    @SuppressWarnings("null")
    public boolean post(Gokulesh c) {
        try {

            repo.save(c);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Gokulesh> getAll() {
        return repo.findAll();

    }

    public List<Gokulesh> getProduct(String age) {
        return repo.findByProductCategory(age);

    }
    public List<Gokulesh> getProductbyprice(String age) {
        return repo.findByPriceCategory(age);

    }

}

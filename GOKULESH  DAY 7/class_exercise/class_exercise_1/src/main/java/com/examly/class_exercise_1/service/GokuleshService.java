package com.examly.class_exercise_1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.examly.class_exercise_1.model.Gokulesh;
import com.examly.class_exercise_1.repository.GokuleshRepo;

@Service
public class GokuleshService {

     @Autowired
     public GokuleshRepo GokuleshRepo;

     public Gokulesh SaveEntity(Gokulesh entity) {
          return GokuleshRepo.save(entity);

     }

     public List<Gokulesh> getDetails() {
          return GokuleshRepo.findAll();

     }

     public List<Gokulesh> findByAge(int byAge) {
          return GokuleshRepo.findByAge(byAge);
     }

}

package com.examly.class_exercise_2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Gokulesh;

import com.examly.class_exercise_2.model.Gokulesh;
import com.examly.class_exercise_2.repository.GokuleshRepo;

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

     public List<Gokulesh> findByCourseName(String courseName) {
          return GokuleshRepo.findByCourseName(courseName);
     }

}

package com.example.class_exercise_2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.class_exercise_1.model.Gokulesh;
import com.example.class_exercise_2.model.Gokulesh;
import com.example.class_exercise_2.repository.GokuleshRepo;

@Service
public class GokuleshService {

     @Autowired
     public GokuleshRepo GokuleshRepo;

     public List<Gokulesh> getAll() {
          return GokuleshRepo.findAll();
     }

     public Gokulesh post(Gokulesh student) {
          return GokuleshRepo.save(student);
     }

     public List<Gokulesh> sortedDetails(String field) {
          return GokuleshRepo.findAll(Sort.by(Sort.Direction.DESC, field));
     }
}

package com.example.class_exercise_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.class_exercise_2.model.Gokulesh;

@Repository
public interface GokuleshRepo extends JpaRepository<Gokulesh, Integer> {

}
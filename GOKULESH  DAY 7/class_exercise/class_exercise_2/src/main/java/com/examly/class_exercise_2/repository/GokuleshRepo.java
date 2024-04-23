package com.examly.class_exercise_2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.class_exercise_2.model.Gokulesh;

@Repository
public interface GokuleshRepo extends JpaRepository<Gokulesh, Integer> {

     List<Gokulesh> findByCourseName(String courseName);

}
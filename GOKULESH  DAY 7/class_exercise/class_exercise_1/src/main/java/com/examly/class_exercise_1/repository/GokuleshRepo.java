package com.examly.class_exercise_1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.class_exercise_1.model.Person;

/**
 * PersonRepo
 */
@Repository
public interface GokuleshRepo extends JpaRepository<Gokulesh, Integer> {

     List<Person> findByAge(int byAge);
}
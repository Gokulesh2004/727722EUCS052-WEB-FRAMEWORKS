package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.examly.springapp.model.Gokulesh;
import java.util.List;

@Repository
public interface GokuleshRepo extends JpaRepository<Gokulesh, Long> {

    List<Gokulesh> findByMarksGreaterThan(int mark);

    List<Gokulesh> findByMarksLessThan(int mark);

}

package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springapp.model.Gokulesh;
import java.util.List;


@Repository
public interface GokuleshRepo extends JpaRepository<Gokulesh,Integer>{

    List<Gokulesh> findByProductNameStartingWith(String name);
    List<Gokulesh> findByProductNameEndingWith(String name);
    
}

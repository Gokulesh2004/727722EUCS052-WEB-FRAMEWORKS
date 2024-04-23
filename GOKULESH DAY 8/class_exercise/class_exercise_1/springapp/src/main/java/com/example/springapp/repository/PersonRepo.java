package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springapp.model.Gokulesh;
import java.util.List;


@Repository
public interface PersonRepo extends JpaRepository<Gokulesh,Integer>{

    List<Gokulesh> findByNameStartingWith(String name);
    List<Gokulesh> findByNameEndingWith(String name);
    
}

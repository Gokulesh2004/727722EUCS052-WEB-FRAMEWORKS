package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.springapp.model.Gokulesh;
import java.util.List;


@Repository
public interface GokuleshRepo extends JpaRepository<Gokulesh,Integer>{

    @Query("select r from Recipe r where recipeName=?1")
    List<Gokulesh> findByProduct(String name);
    
}

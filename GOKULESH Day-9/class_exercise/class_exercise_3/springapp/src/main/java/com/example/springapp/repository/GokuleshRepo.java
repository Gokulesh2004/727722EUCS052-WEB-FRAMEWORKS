package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.day5cw2.model.Gokulesh;
import com.example.springapp.model.Gokulesh;
import java.util.List;

@Repository
public interface GokuleshRepo extends JpaRepository<Gokulesh, Integer> {

    @Query("select v from Village as v where v.villageName=?1")
    Gokulesh findByName(String villageName);

    @Query("select v from Village as v where v.villageId=?1")
    Gokulesh findById(int id);

    @Query("select v from Village as v where v.villagePopulation=?1")
    List<Gokulesh> findByPopulation(int population);

}

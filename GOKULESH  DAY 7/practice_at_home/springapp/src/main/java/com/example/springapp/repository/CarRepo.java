package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springapp.model.Gokulesh;


@Repository
public interface CarRepo extends JpaRepository<Gokulesh,Integer>{

    Car findDistinctBycurrentOwnerNameAndAddress(String currentOwnerName, String address); 
}

package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Gokulesh;

@Repository
public interface GokuleshRepo extends JpaRepository<Gokulesh, Integer> {

    public List<Gokulesh> findByProductCategory(String productCategory);
    public List<Gokulesh> findByPriceCategory(String priceCategory);

}

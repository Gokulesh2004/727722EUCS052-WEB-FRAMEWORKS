package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Door;
import com.examly.springapp.model.Gokulesh;

// import jakarta.transaction.Transactiona

@Repository
public interface GokuleshRepo extends JpaRepository<Gokulesh, Integer> {

    @Query(value = "DELETE FROM Door WHERE Door_id = ?1", nativeQuery = true)
    void deleteDoor(int DoorId);

    public List<Gokulesh> findByColor(String color);

    public List<Gokulesh> findByDoorType(String doortype);
}

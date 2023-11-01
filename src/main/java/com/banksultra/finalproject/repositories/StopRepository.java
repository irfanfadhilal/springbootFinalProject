package com.banksultra.finalproject.repositories;

import com.banksultra.finalproject.models.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StopRepository extends JpaRepository<Stop, Long> {
    String findDataById = "SELECT * FROM stop WHERE id = :id";
    @Query(value = findDataById, nativeQuery = true)
    public Stop findDataById(Long id);
}

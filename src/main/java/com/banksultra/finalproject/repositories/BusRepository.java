package com.banksultra.finalproject.repositories;

import com.banksultra.finalproject.models.Bus;
import com.banksultra.finalproject.models.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
    String findDataById = "SELECT * FROM bus WHERE id = :id";
    @Query(value = findDataById, nativeQuery = true)
    public Bus findDataById(Long id);
}

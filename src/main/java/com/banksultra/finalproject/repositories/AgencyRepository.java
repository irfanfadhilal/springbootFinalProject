package com.banksultra.finalproject.repositories;

import com.banksultra.finalproject.models.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {
    String findDataById = "SELECT * FROM agency WHERE id = :id";
    @Query(value = findDataById, nativeQuery = true)
    public Agency findDataById(Long id);
}

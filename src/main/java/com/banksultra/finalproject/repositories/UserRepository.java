package com.banksultra.finalproject.repositories;

import com.banksultra.finalproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);

    String sqlFindById = "SELECT * FROM user WHERE id = :id";
    @Query(value = sqlFindById, nativeQuery = true)
    public User findById(Long id);

    String sqlFindDataByEmail = "SELECT * FROM user WHERE email = :email";
    @Query(value = sqlFindDataByEmail, nativeQuery = true)
    public User sqlFindDataByEmail(String email);

    String sqlInsertUserRole = "INSERT INTO user_role (user_id, role_id) VALUES (:userId, :roleId)";
    @Modifying
    @Transactional
    @Query(value = sqlInsertUserRole, nativeQuery = true)
    public void sqlInsertUserRole(Long userId, Long roleId);
}

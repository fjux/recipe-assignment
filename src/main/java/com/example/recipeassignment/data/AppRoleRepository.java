package com.example.recipeassignment.data;

import com.example.recipeassignment.model.constants.UserRole;
import com.example.recipeassignment.model.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AppRoleRepository extends JpaRepository<AppRole, String> {
    @Query("SELECT r FROM AppRole r WHERE r.userRole = :role")
    Optional<AppRole> findByUserRole(@Param("role")UserRole userRole);
}

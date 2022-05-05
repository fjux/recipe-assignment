package com.example.recipeassignment.data;

import com.example.recipeassignment.model.constants.UserRole;
import com.example.recipeassignment.model.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
    @Query("SELECT u FROM AppUser u WHERE UPPER(u.username) = UPPER(:username)")
    Optional<AppUser> findByUsername(@Param("username") String username);
    @Query("SELECT u FROM AppUser u JOIN FETCH u.roles as role WHERE role.userRole = :role")
    List<AppUser> findByUserRole(@Param("role")UserRole role);
}

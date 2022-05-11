package com.example.recipeassignment.data;

import com.example.recipeassignment.model.constants.UserRole;
import com.example.recipeassignment.model.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, String> {

    Optional<AppUser> findByUsername(String username);
    Optional<AppUser> findByEmail(String email);
    List<AppUser> findByUserRole(UserRole userRole);
}

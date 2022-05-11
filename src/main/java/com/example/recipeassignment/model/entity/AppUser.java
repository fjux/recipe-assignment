package com.example.recipeassignment.model.entity;

import com.example.recipeassignment.model.constants.UserRole;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

import static com.example.recipeassignment.model.constants.EntityConstants.GENERATOR;
import static com.example.recipeassignment.model.constants.EntityConstants.UUID_GENERATOR;

@Entity
@Table(name = "app_users")
public class AppUser {
    @Id
    @GeneratedValue(generator = GENERATOR)
    @GenericGenerator(name = GENERATOR, strategy = UUID_GENERATOR)
    @Column(updatable = false, name = "id")
    private String userId;
    @Column(name = "username", length = 100, unique = true)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "user_role")
    private UserRole userRole;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "reg_date")
    private LocalDate registrationDate;
    @Column(name = "suspended")
    private boolean suspended;

    public AppUser(String userId, String username, String password, String email, LocalDate registrationDate, boolean suspended) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.registrationDate = registrationDate;
        this.suspended = suspended;
    }

    public AppUser() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }

    @PrePersist
    void prePersist(){
        registrationDate = LocalDate.now();
    }
}
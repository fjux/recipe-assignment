package com.example.recipeassignment.model.dto.view;

import com.example.recipeassignment.model.constants.UserRole;

import java.io.Serializable;
import java.time.LocalDate;

public class AppUserDTO implements Serializable {
    private String appUserDTOId;
    private String username;
    private UserRole userRole;
    private String email;
    private LocalDate registrationDate;
    private boolean suspended;

    public AppUserDTO() {
    }

    public String getAppUserDTOId() {
        return appUserDTOId;
    }

    public void setAppUserDTOId(String appUserDTOId) {
        this.appUserDTOId = appUserDTOId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}

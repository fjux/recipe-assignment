package com.example.recipeassignment.model.dto.view;

import com.example.recipeassignment.model.constants.UserRole;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

public class AppUserDTO implements Serializable {
    private String appUserDTOId;
    private String username;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<UserRole> roles;

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

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }
}

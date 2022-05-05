package com.example.recipeassignment.model.entity;

import com.example.recipeassignment.model.constants.UserRole;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static com.example.recipeassignment.model.constants.EntityConstants.GENERATOR;
import static com.example.recipeassignment.model.constants.EntityConstants.UUID_GENERATOR;

@Entity
public class AppRole {
    @Id
    @GeneratedValue(generator = GENERATOR)
    @GenericGenerator(name = GENERATOR, strategy = UUID_GENERATOR)
    @Column(updatable = false)
    private String appRoleId;
    @Column(unique = true)
    private UserRole userRole;
    @ManyToMany(
            cascade = {CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "role_app_user",
            joinColumns = @JoinColumn(name = "fk_app_role_id", table = "role_app_user"),
            inverseJoinColumns = @JoinColumn(name = "fk_app_user_id", table = "role_app_user")
    )
    private Set<AppUser> appUsers;

    public AppRole(String appRoleId, UserRole userRole) {
        this.appRoleId = appRoleId;
        this.userRole = userRole;
    }

    public AppRole() {
    }

    public String getAppRoleId() {
        return appRoleId;
    }

    public void setAppRoleId(String appRoleId) {
        this.appRoleId = appRoleId;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Set<AppUser> getAppUsers() {
        if(appUsers == null) appUsers = new HashSet<>();
        return appUsers;
    }

    public void setAppUsers(Set<AppUser> appUsers) {
        if(appUsers == null) appUsers = new HashSet<>();
        if(appUsers.isEmpty()) {
            if (this.appUsers != null) {
                this.appUsers.forEach(appUser -> appUser.getRoles().remove(this));
            }
        }else{
            appUsers.forEach(appUser -> appUser.getRoles().add(this));
        }
        this.appUsers = appUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppRole)) return false;
        AppRole appRole = (AppRole) o;
        return userRole == appRole.userRole;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userRole);
    }

    @Override
    public String toString() {
        return "AppRole{" +
                "appRoleId='" + appRoleId + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}

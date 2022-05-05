package com.example.recipeassignment.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static com.example.recipeassignment.model.constants.EntityConstants.GENERATOR;
import static com.example.recipeassignment.model.constants.EntityConstants.UUID_GENERATOR;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(generator = GENERATOR)
    @GenericGenerator(name = GENERATOR, strategy = UUID_GENERATOR)
    @Column(updatable = false)
    private String userId;
    @Column(length = 100, unique = true)
    private String username;
    private String password;
    @ManyToMany
    private Set<AppRole> roles;

    public AppUser(String userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
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

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<AppRole> getRoles() {
        if(roles == null) roles = new HashSet<>();
        return roles;
    }

    public void setRoles(Set<AppRole> roles) {
        if(roles == null) roles = new HashSet<>();
        if(roles.isEmpty()) {
            if (this.roles != null) {
                this.roles.forEach(appRole -> appRole.getAppUsers().remove(this));
            }
        }else{
            roles.forEach(appRole -> appRole.getAppUsers().add(this));
        }
        this.roles = roles;
    }

    public void addAppRole(AppRole appRole){
        if(appRole == null) throw new IllegalArgumentException("AppRole was null");
        if(roles == null) roles = new HashSet<>();
        roles.add(appRole);
        appRole.getAppUsers().add(this);
    }

    public void removeAppRole(AppRole appRole){
        if(appRole == null) throw new IllegalArgumentException("AppRole was null");
        if(roles == null) roles = new HashSet<>();
        roles.remove(appRole);
        appRole.getAppUsers().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppUser)) return false;
        AppUser appUser = (AppUser) o;
        return getUserId().equals(appUser.getUserId()) && getUsername().equals(appUser.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getUsername());
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "userId='" + userId + '\'' +
                ", userName='" + username + '\'' +
                '}';
    }
}

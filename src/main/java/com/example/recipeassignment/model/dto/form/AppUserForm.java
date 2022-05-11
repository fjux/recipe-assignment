package com.example.recipeassignment.model.dto.form;

import com.example.recipeassignment.model.constants.UserRole;
import com.example.recipeassignment.validation.OnPost;
import com.example.recipeassignment.validation.OnPut;
import com.example.recipeassignment.validation.UniqueEmail;
import com.example.recipeassignment.validation.UniqueUsername;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

import static com.example.recipeassignment.validation.messages.ValidationMessages.*;

@Validated
public class AppUserForm implements Serializable {
    @NotBlank(message = MANDATORY_FIELD, groups = OnPut.class)
    private String appUserFormId;
    @NotBlank(message = MANDATORY_FIELD, groups = {OnPost.class, OnPut.class})
    @Size(min = 6, max = 100, message = USERNAME_SIZE, groups = {OnPost.class, OnPut.class})
    @UniqueUsername(message = USERNAME_TAKEN, groups = OnPost.class)
    private String username;
    @NotBlank(message = MANDATORY_FIELD, groups = OnPost.class)
    @Pattern(message = WEAK_PASSWORD, regexp = PASSWORD_REGEX, groups = OnPost.class)
    private String password;
    private UserRole userRole;
    @NotBlank(message = MANDATORY_FIELD, groups = {OnPost.class, OnPut.class})
    @UniqueEmail(message = EMAIL_NOT_AVAILABLE, groups = OnPost.class)
    private String email;
    private LocalDate registrationDate;
    private boolean suspended;

    public AppUserForm() {
    }

    public AppUserForm(String appUserFormId, String username, String password, UserRole userRole, String email, LocalDate registrationDate, boolean suspended) {
        this.appUserFormId = appUserFormId;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.email = email;
        this.registrationDate = registrationDate;
        this.suspended = suspended;
    }

    public String getAppUserFormId() {
        return appUserFormId;
    }

    public void setAppUserFormId(String appUserFormId) {
        this.appUserFormId = appUserFormId;
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
}

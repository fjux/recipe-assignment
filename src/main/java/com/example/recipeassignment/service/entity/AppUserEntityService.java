package com.example.recipeassignment.service.entity;

import com.example.recipeassignment.model.constants.UserRole;
import com.example.recipeassignment.model.dto.form.AppUserForm;
import com.example.recipeassignment.model.entity.AppUser;

import java.util.List;

public interface AppUserEntityService extends GenericEntityService<AppUser, AppUserForm, String> {
    AppUser findByUsername(String username);
    List<AppUser> findByUserRole(UserRole role);
    AppUser create(AppUserForm form, UserRole role);
    AppUser addRole(String id, UserRole role);
    AppUser removeRole(String id, UserRole role);
}

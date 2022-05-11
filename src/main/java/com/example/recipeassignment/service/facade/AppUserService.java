package com.example.recipeassignment.service.facade;

import com.example.recipeassignment.model.constants.UserRole;
import com.example.recipeassignment.model.dto.form.AppUserForm;
import com.example.recipeassignment.model.dto.view.AppUserDTO;

import java.util.List;

public interface AppUserService {
    AppUserDTO create(AppUserForm form, UserRole role);
    AppUserDTO findById(String id);
    AppUserDTO findByUsername(String username);
    List<AppUserDTO> findAll();
    List<AppUserDTO> findByUserRole(UserRole role);
    AppUserDTO update(String id, AppUserForm form);
    void delete(String id);
}

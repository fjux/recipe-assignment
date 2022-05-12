package com.example.recipeassignment.controllers;

import com.example.recipeassignment.model.constants.UserRole;
import com.example.recipeassignment.model.dto.form.AppUserForm;
import com.example.recipeassignment.model.dto.view.AppUserDTO;
import com.example.recipeassignment.service.facade.AppUserService;
import com.example.recipeassignment.validation.OnPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Paths;

@RestController
public class AppUserController {

    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;

    }

    @PostMapping("/api/v1/public/register")
    public ResponseEntity<AppUserDTO> register(@Validated(OnPost.class) @RequestBody AppUserForm appUserForm) {
        return ResponseEntity.created(Paths.get("/api/v1/public/register").toUri()).body(
                appUserService.create(appUserForm, UserRole.ROLE_USER)
        );
    }

}


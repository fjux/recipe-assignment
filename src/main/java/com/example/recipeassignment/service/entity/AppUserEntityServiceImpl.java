package com.example.recipeassignment.service.entity;

import com.example.recipeassignment.data.AppUserRepository;
import com.example.recipeassignment.exception.AppResourceNotFoundException;
import com.example.recipeassignment.model.constants.UserRole;
import com.example.recipeassignment.model.dto.form.AppUserForm;
import com.example.recipeassignment.model.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class AppUserEntityServiceImpl implements AppUserEntityService{

    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AppUserEntityServiceImpl(AppUserRepository appUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appUserRepository = appUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public AppUser findByUsername(String username) {
        return appUserRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("Could not find a user with username: " + username));
    }

    @Override
    public List<AppUser> findByUserRole(UserRole role) {
        return appUserRepository.findByUserRole(role);
    }

    @Override
    public AppUser create(AppUserForm form, UserRole role) {
        if(form == null) throw new IllegalArgumentException("App user form was null");
        AppUser appUser = new AppUser();
        appUser.setUsername(form.getUsername());
        appUser.setPassword(bCryptPasswordEncoder.encode(form.getPassword()));
        appUser.setUserRole(form.getUserRole());
        appUser.setEmail(form.getEmail());
        appUser.setSuspended(false);
        return appUserRepository.save(appUser);
    }


    @Override
    public AppUser create(AppUserForm appUserForm) {
        if(appUserForm == null){
            throw new IllegalArgumentException("App user form was null");
        }
        return create(appUserForm, UserRole.ROLE_USER);
    }

    @Override
    public AppUser findById(String id) {
        return appUserRepository.findById(id)
                .orElseThrow(()-> new AppResourceNotFoundException("Could not find a user with provided id: " + id));
    }

    @Override
    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser update(String id, AppUserForm appUserForm) {
        if(id == null) throw new IllegalArgumentException("Id was null");
        if(appUserForm == null) throw new IllegalArgumentException("AppUser form was null");
        if(!id.equals(appUserForm.getAppUserFormId())){
            throw new IllegalStateException("Id did not match appUserFormId");
        }

        AppUser appUser = findById(id);
        Optional<AppUser> optional = appUserRepository.findByUsername(appUserForm.getUsername().trim());
        if(optional.isPresent() && !id.equals(optional.get().getUserId())){
            throw new IllegalArgumentException("Username is already taken");
        }else {
            appUser.setUsername(appUserForm.getUsername().trim());
        }
        Optional<AppUser> optional1 = appUserRepository.findByEmail(appUserForm.getEmail().trim());
        if(optional1.isPresent() && !id.equals(optional1.get().getUserId())){
            throw new IllegalArgumentException("Email is already taken");
        }else{
            appUser.setEmail(appUserForm.getEmail().trim());
        }
        appUser.setPassword(bCryptPasswordEncoder.encode(appUserForm.getPassword()));

        return appUserRepository.save(appUser);
    }

    @Override
    public void delete(String id) {
        appUserRepository.deleteById(id);
    }
}

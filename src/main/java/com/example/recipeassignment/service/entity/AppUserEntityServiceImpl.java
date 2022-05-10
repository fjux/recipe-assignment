package com.example.recipeassignment.service.entity;

import com.example.recipeassignment.data.AppRoleRepository;
import com.example.recipeassignment.data.AppUserRepository;
import com.example.recipeassignment.exception.AppResourceNotFoundException;
import com.example.recipeassignment.model.constants.UserRole;
import com.example.recipeassignment.model.dto.form.AppUserForm;
import com.example.recipeassignment.model.entity.AppRole;
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
    private final AppRoleRepository appRoleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AppUserEntityServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
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
        AppRole appRole = appRoleRepository.findByUserRole(role)
                .orElseThrow(()-> new AppResourceNotFoundException("Could not find AppRole"));
        appUser.addAppRole(appRole);
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser addRole(String id, UserRole role) {
        AppUser appUser = findById(id);
        AppRole appRole = appRoleRepository.findByUserRole(role)
                .orElseThrow(()-> new AppResourceNotFoundException("Could not find role"));
        appUser.addAppRole(appRole);

        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser removeRole(String id, UserRole role) {
        AppUser appUser = findById(id);
        AppRole appRole = appRoleRepository.findByUserRole(role)
                .orElseThrow(()-> new AppResourceNotFoundException("Could not find role"));
        appUser.removeAppRole(appRole);

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
        AppUser appUser = findById(id);
        Optional<AppUser> optional = appUserRepository.findByUsername(appUserForm.getUsername().trim());
        if(optional.isPresent() && !id.equals(optional.get().getUserId())){
            throw new IllegalArgumentException("Username is already taken");
        }
        appUser.setUsername(appUserForm.getUsername());
        appUser.setPassword(bCryptPasswordEncoder.encode(appUserForm.getPassword()));
        appUser = appUserRepository.save(appUser);
        return appUser;
    }

    @Override
    public void delete(String id) {
        AppUser appUser = findById(id);
        appUser.setRoles(null);
        appUserRepository.deleteById(id);
    }
}

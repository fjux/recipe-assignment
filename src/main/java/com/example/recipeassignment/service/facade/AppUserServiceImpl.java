package com.example.recipeassignment.service.facade;

import com.example.recipeassignment.model.constants.UserRole;
import com.example.recipeassignment.model.dto.form.AppUserForm;
import com.example.recipeassignment.model.dto.view.AppUserDTO;
import com.example.recipeassignment.service.entity.AppUserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AppUserServiceImpl implements AppUserService{

    private final AppUserEntityService appUserEntityService;
    private final DTOService dtoService;

    @Autowired
    public AppUserServiceImpl(AppUserEntityService appUserEntityService, DTOService dtoService) {
        this.appUserEntityService = appUserEntityService;
        this.dtoService = dtoService;
    }

    @Override
    public AppUserDTO create(AppUserForm form, UserRole role) {
        return dtoService.toFullAppUserDTO(appUserEntityService.create(form, role));
    }

    @Override
    public AppUserDTO findById(String id) {
        return dtoService.toFullAppUserDTO(appUserEntityService.findById(id));
    }

    @Override
    public AppUserDTO findByUsername(String username) {
        return dtoService.toFullAppUserDTO(appUserEntityService.findByUsername(username));
    }

     @Override
    public List<AppUserDTO> findAll() {
        return appUserEntityService.findAll().stream()
                .map(dtoService::toFullAppUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppUserDTO> findByUserRole(UserRole role) {
        return appUserEntityService.findByUserRole(role).stream()
                .map(dtoService::toFullAppUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AppUserDTO update(String id, AppUserForm form) {
        return dtoService.toFullAppUserDTO(appUserEntityService.update(id, form));
    }

    @Override
    public void delete(String id) {
        appUserEntityService.delete(id);
    }
}

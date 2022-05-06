package com.example.recipeassignment.security;

import com.example.recipeassignment.data.AppUserRepository;
import com.example.recipeassignment.model.entity.AppRole;
import com.example.recipeassignment.model.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AppUserDetailsServiceImpl implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserDetailsServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No user with username: " + username + " was found"));

        AppUserDetails appUserDetails = new AppUserDetails();
        appUserDetails.setUserId(appUser.getUserId());
        appUserDetails.setUsername(username);
        appUserDetails.setPassword(appUser.getPassword());
        appUserDetails.setActive(true);
        Set<SimpleGrantedAuthority> authoritySet = new HashSet<>();
        for(AppRole appRole : appUser.getRoles()){
            authoritySet.add(new SimpleGrantedAuthority(appRole.getUserRole().name()));
        }
        appUserDetails.setAuthorities(authoritySet);
        return appUserDetails;
    }
}

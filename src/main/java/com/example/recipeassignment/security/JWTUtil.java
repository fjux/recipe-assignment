package com.example.recipeassignment.security;

import com.example.recipeassignment.model.entity.AppRole;
import com.example.recipeassignment.model.entity.AppUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

import static com.example.recipeassignment.security.SecurityConstants.*;

@Component
public class JWTUtil {
    public Claims parseClaims(String jwt){
        SecretKey key = Keys.hmacShaKeyFor(JWT_KEY.getBytes(StandardCharsets.UTF_8));
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }
    public AppUserDetails fromClaims(Claims claims){
        String username = claims.getSubject();
        String userId = claims.get(USER_ID, String.class);
        String authorities = claims.get(AUTHORITIES, String.class);
        Set<SimpleGrantedAuthority> authoritySet = Arrays.stream(authorities.split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());

        AppUserDetails appUserDetails = new AppUserDetails();
        appUserDetails.setUserId(userId);
        appUserDetails.setAuthorities(authoritySet);
        appUserDetails.setUsername(username);
        return appUserDetails;
    }
    public String fromAppUserDetails(AppUserDetails appUserDetails){
        SecretKey key = Keys.hmacShaKeyFor(JWT_KEY.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .setIssuer(RECIPE_ASSIGNMENT)
                .setHeaderParam("typ", "JWT")
                .setSubject(appUserDetails.getUsername())
                .claim(AUTHORITIES, populateAuthorities(appUserDetails.getAuthorities()))
                .claim(USER_ID, appUserDetails.getUserId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(
                        System.currentTimeMillis() + 3_600_000
                ))
                .signWith(key, SignatureAlgorithm.HS512).compact();
    }
    public String populateAuthorities(Collection<? extends GrantedAuthority> authorities){
        Set<String> authoritiesSet = new HashSet<>();
        for(GrantedAuthority authority : authorities){
            authoritiesSet.add(authority.getAuthority());
        }
        return String.join(",", authoritiesSet);
    }

    public String populateAuthorities(AppUser appUser){
        Set<String> authorities = new HashSet<>();
        for(AppRole appRole : appUser.getRoles()){
            authorities.add(appRole.getUserRole().name());
        }
        return String.join(",", authorities);
    }

    private String fromAppUser(AppUser appUser){
        SecretKey key = Keys.hmacShaKeyFor(JWT_KEY.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .setIssuer(RECIPE_ASSIGNMENT)
                .setHeaderParam("typ", "JWT")
                .setSubject(appUser.getUsername())
                .claim(AUTHORITIES, populateAuthorities(appUser))
                .claim(USER_ID, appUser.getUserId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(
                        System.currentTimeMillis() + 3_600_000
                ))
                .signWith(key, SignatureAlgorithm.HS512).compact();
    }
}

package com.example.recipeassignment.security;

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
        String userId = claims.get(USER_ID, String.class);
        String username = claims.getSubject();
        String email = claims.get(EMAIL, String.class);
        String authorities = claims.get(AUTHORITIES, String.class);
        Boolean suspended = claims.get(SUSPENDED, Boolean.class);
        Collection<GrantedAuthority> grantedAuthorities = Arrays.stream(authorities.split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());

        return new AppUserDetails(userId, username, null, email, suspended, grantedAuthorities);
    }
    public String buildToken(AppUserDetails appUserDetails){
        SecretKey key = Keys.hmacShaKeyFor(JWT_KEY.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .setIssuer(RECIPE_ASSIGNMENT)
                .setHeaderParam("typ", "JWT")
                .setSubject(appUserDetails.getUsername())
                .claim(AUTHORITIES, getAuthorityString(appUserDetails.getAuthorities()))
                .claim(USER_ID, appUserDetails.getUserId())
                .claim(EMAIL, appUserDetails.getEmail())
                .claim(SUSPENDED, appUserDetails.isEnabled())
                .setIssuedAt(new Date())
                .setExpiration(new Date(
                        System.currentTimeMillis() + (3_600_000 * 24)
                ))
                .signWith(key, SignatureAlgorithm.HS512).compact();
    }
    public String getAuthorityString(Collection<? extends GrantedAuthority> authorities){
        Set<String> authoritySet = new HashSet<>();
        for(GrantedAuthority authority : authorities){
            authoritySet.add(authority.getAuthority());
        }
        return String.join(",", authoritySet);
    }
}

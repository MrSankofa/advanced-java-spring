package com.codingnomads.springsecurity.recipeapi.services;

import com.codingnomads.springsecurity.recipeapi.models.securitymodels.Role;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GrantedAuthorityService {

    public ArrayList<Role> getGrantedAuthoritiesByUserId(Long userId) {
        return new ArrayList<>();
    }
}

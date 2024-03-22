/* CodingNomads (C)2024 */
package com.codingnomads.springsecurity.recipeapi.services;

import com.codingnomads.springsecurity.recipeapi.models.securitymodels.Role;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class GrantedAuthorityService {

    public ArrayList<Role> getGrantedAuthoritiesByUserId(Long userId) {
        return new ArrayList<>();
    }
}

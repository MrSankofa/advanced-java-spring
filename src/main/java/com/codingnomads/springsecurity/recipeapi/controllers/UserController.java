/* CodingNomads (C)2023 */
package com.codingnomads.springsecurity.recipeapi.controllers;

import com.codingnomads.springsecurity.recipeapi.models.securitymodels.CustomUserDetails;
import com.codingnomads.springsecurity.recipeapi.services.userservices.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    CustomUserDetailService userDetailService;

    @GetMapping("/current-user")
    public CustomUserDetails getUser(Authentication authentication) {
        return (CustomUserDetails) authentication.getPrincipal();
    }

    @PostMapping("/new-user")
    public ResponseEntity<?> createNewUser(@RequestBody CustomUserDetails userDetails) {
        try {
            return ResponseEntity.ok(userDetailService.createNewUser(userDetails));
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}

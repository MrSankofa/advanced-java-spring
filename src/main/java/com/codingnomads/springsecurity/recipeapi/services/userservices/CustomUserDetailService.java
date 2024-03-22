/* CodingNomads (C)2024 */
package com.codingnomads.springsecurity.recipeapi.services.userservices;

import com.codingnomads.springsecurity.recipeapi.exceptions.NoSuchUserException;
import com.codingnomads.springsecurity.recipeapi.models.securitymodels.CustomUserDetails;
import com.codingnomads.springsecurity.recipeapi.models.securitymodels.Role;
import com.codingnomads.springsecurity.recipeapi.repositories.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.Optional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUserDetails optionalUser = userRepo.findByUsername(username);

        if (optionalUser == null) {
            throw new UsernameNotFoundException(username + " is not a valid username! Check for typos and try again.");
        }

        return optionalUser;
    }

    @Transactional(readOnly = true)
    public CustomUserDetails getByUserId(Long userId) throws NoSuchUserException {

        Optional<CustomUserDetails> optional = userRepo.findById(userId);
        CustomUserDetails user;
        if (optional.isEmpty()) {
            throw new EntityNotFoundException("User not found.");
        } else {
            user = optional.get();
        }

        return (CustomUserDetails) Hibernate.unproxy(user);
    }

    public CustomUserDetails createNewUser(CustomUserDetails userDetails) {
        userDetails.setId(null);
        userDetails.getAuthorities().forEach(a -> a.setId(null));

        // override or set user settings to correct values
        userDetails.setAccountNonExpired(true);
        userDetails.setAccountNonLocked(true);
        userDetails.setCredentialsNonExpired(true);
        userDetails.setEnabled(true);
        userDetails.setAuthorities(Collections.singletonList(new Role(Role.Roles.ROLE_USER)));

        checkPassword(userDetails.getPassword());
        userDetails.setPassword(encoder.encode(userDetails.getPassword()));
        try {
            return userRepo.save(userDetails);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e.getCause());
        }
    }

    private void checkPassword(String password) {
        if (password == null) {
            throw new IllegalStateException("You must set a password");
        }
        if (password.length() < 6) {
            throw new IllegalStateException("Password is too short. Must be larger than 6 characters");
        }
    }
}

/* CodingNomads (C)2023 */
package com.codingnomads.springsecurity.authorization.addingauthorization.services;

import com.codingnomads.springsecurity.authorization.addingauthorization.models.UserMeta;
import com.codingnomads.springsecurity.authorization.addingauthorization.models.UserPrincipal;
import com.codingnomads.springsecurity.authorization.addingauthorization.repositories.UserMetaRepo;
import com.codingnomads.springsecurity.authorization.addingauthorization.repositories.UserPrincipalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    UserPrincipalRepo userPrincipalRepo;

    @Autowired
    UserMetaRepo userMetaRepo;

    @Override
    public UserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
        return userPrincipalRepo
                .findByUsername(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User not found with username or email : " + username));
    }

    public UserMeta updateUserMeta(UserMeta userToUpdate) {
        UserMeta updatedUser = userMetaRepo.save(userToUpdate);
        UserPrincipal userPrincipal = (UserPrincipal)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userPrincipal.setUserMeta(userToUpdate);
        return updatedUser;
    }
}

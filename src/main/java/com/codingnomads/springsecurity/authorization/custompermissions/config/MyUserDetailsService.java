/* CodingNomads (C)2023 */
package com.codingnomads.springsecurity.authorization.custompermissions.config;

import com.codingnomads.springsecurity.authorization.custompermissions.models.User;
import com.codingnomads.springsecurity.authorization.custompermissions.repositories.AuthRepository;
import com.codingnomads.springsecurity.authorization.custompermissions.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    AuthRepository authRepository;

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userService.getUser(email.toLowerCase());
        if (user == null) {
            throw new UsernameNotFoundException("User with email: " + email + " not found!!");
        }
        return new org.springframework.security.core.userdetails.User(
                email, user.getPassword(), true, true, true, true, authRepository.findAllByObjectId(user.getId()));
    }
}

/* CodingNomads (C)2024 */
package com.codingnomads.springsecurity.authentication.usernamepassword.security;

import com.codingnomads.springsecurity.authentication.usernamepassword.models.Authority;
import com.codingnomads.springsecurity.authentication.usernamepassword.models.RoleEnum;
import com.codingnomads.springsecurity.authentication.usernamepassword.models.UserPrincipal;
import com.codingnomads.springsecurity.authentication.usernamepassword.services.CustomUserDetailsService;
import java.util.Collections;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// commented out, so it's not picked up by Spring
// @Configuration
// @EnableWebSecurity
public class MultipleProviderExample {

    @Autowired
    DataSource dataSource;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // start the process of customizing authorization settings.
                // this will be covered in depth in the authorization chapter.
                .authorizeHttpRequests(auth -> auth
                        // CSS should be accessible for all
                        .requestMatchers("/css/**", "/webjars/**")
                        .permitAll()
                        // all other requests should be authenticated
                        .anyRequest()
                        .authenticated())
                // formLogin() is used to indicate an HTML form is going to
                // be used to present a username and password. it also adds the
                // UsernamePasswordAuthenticationFilter to the filter chain
                .formLogin(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // this bean adds all three AuthenticationProviders to the AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return new ProviderManager(List.of(
                inMemoryAuthenticationProvider(), jdbcAuthenticationProvider(), customAuthenticationProvider()));
    }

    // custom AuthenticationProvider for the in-memory UserDetailsService
    @Bean
    public AuthenticationProvider inMemoryAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(inMemoryUserDetailsManager());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    // custom AuthenticationProvider for the JDBC UserDetailsService
    @Bean
    public AuthenticationProvider jdbcAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(jdbcUserDetails(dataSource));
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    // custom AuthenticationProvider for the CustomUserDetailsService class
    @Bean
    public AuthenticationProvider customAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public UserDetailsManager jdbcUserDetails(DataSource dataSource) {
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.setAuthoritiesByUsernameQuery(
                "SELECT a.id, a.authority FROM authorities a " + "JOIN user_authority_join_table jt "
                        + "ON a.id = jt.authority_id "
                        + "JOIN users u ON u.id = jt.user_id "
                        + "WHERE u.username = ?");
        users.setUsersByUsernameQuery("SELECT username, password, enabled " + "FROM users WHERE username = ?");
        return users;
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        Authority userAuth = Authority.builder().authority(RoleEnum.ROLE_USER).build();
        UserPrincipal user1 =
                new UserPrincipal("USER1", passwordEncoder().encode("hi"), Collections.singletonList(userAuth));
        UserPrincipal user2 =
                new UserPrincipal("USER2", passwordEncoder().encode("hello"), Collections.singletonList(userAuth));
        return new InMemoryUserDetailsManager(user1, user2);
    }
}

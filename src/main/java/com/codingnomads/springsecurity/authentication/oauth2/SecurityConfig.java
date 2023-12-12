/* CodingNomads (C)2023 */
package com.codingnomads.springsecurity.authentication.oauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.requestMatchers("/")
                        .permitAll()
                        .requestMatchers("/protected")
                        .authenticated()
                        .anyRequest()
                        .permitAll())
                .oauth2Login(Customizer.withDefaults());
        return http.build();
    }
}

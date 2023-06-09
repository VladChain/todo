package com.apress.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class OAuth2LoginSecurityConfig extends WebSecurityConfiguration {

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizedRequest ->
                authorizedRequest.anyRequest().authenticated())
                .oauth2Login(Customizer.withDefaults());
        return http.build();
    }
}

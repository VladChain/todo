package com.apress.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

public class OAuth2LoginConfig {

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(this.githubClientregistration());
    }

    // Taking date from application.properties
    private ClientRegistration githubClientregistration() {
        return ClientRegistration.withRegistrationId("github")
                .clientId("client-id")
                .clientSecret("client-secret")
                .clientName("client-name")
                .scope("scope")
                .redirectUri("redirect-uri-template")
                .clientName("github")
                .build();
    }
}

package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/api/v1/admin/login").permitAll() // Allow public access to login
                .anyRequest().authenticated() // Other endpoints require authentication
            )
            .formLogin(form -> form
                .permitAll() // Enables form-based authentication
            )
            .logout(logout -> logout
                .permitAll() // Allow all users to log out
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Remove @Bean annotation and return type must not be void
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Configure in-memory authentication (for demonstration purposes)
        auth.inMemoryAuthentication()
            .withUser("yourUsername") // Define your username
            .password(passwordEncoder().encode("yourPassword")) // Define your password
            .roles("USER"); // Define roles
    }
}

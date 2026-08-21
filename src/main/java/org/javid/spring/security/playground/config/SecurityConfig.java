package org.javid.spring.security.playground.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/hello").permitAll()
                        .requestMatchers("/public").permitAll()
                        .requestMatchers("/user").authenticated()
                        .requestMatchers("/admin").authenticated()
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    CommandLineRunner inspectSecurity(UserDetailsService userDetailsService) {
        return _ -> {
            IO.print("UserDetailsService = %s%n".formatted(userDetailsService.getClass()));

            var user = userDetailsService.loadUserByUsername("user");
            IO.print("User = %s%n".formatted(user));

            IO.print("Authorities = %s%n".formatted(user.getAuthorities()));
        };
    }
}

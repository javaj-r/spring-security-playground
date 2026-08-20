package org.javid.spring.security.playground.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Security!";
    }

    @GetMapping("/profile")
    public String profile() {
        return "This is your profile";
    }

    @GetMapping("/public")
    public String publicGet() {
        return "This is public request";
    }

    @GetMapping("/user")
    public String user(Authentication authentication) {
        return """
                Principal: %s
                Name: %s
                Authenticated: %s
                Authorities: %s
                """.formatted(
                authentication.getPrincipal(),
                authentication.getName(),
                authentication.isAuthenticated(),
                authentication.getAuthorities());
    }

    @GetMapping("/admin")
    public String admin() {
        return "This is admin";
    }
}

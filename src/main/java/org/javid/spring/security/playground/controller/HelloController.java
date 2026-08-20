package org.javid.spring.security.playground.controller;

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
    public String user() {
        return "This is user";
    }

    @GetMapping("/admin")
    public String admin() {
        return "This is admin";
    }
}

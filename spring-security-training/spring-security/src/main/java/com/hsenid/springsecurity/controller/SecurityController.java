package com.hsenid.springsecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class SecurityController {

    @GetMapping("/home")
    public ResponseEntity<String> getHome() {
        return ResponseEntity.ok("This is home page");
    }

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<String> getDashboard() {
        return ResponseEntity.ok("This is dashboard page");
    }

    @GetMapping("/manage")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> getManage() {
        return ResponseEntity.ok("This is manage page");
    }
}
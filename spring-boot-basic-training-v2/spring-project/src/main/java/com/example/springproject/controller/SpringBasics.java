package com.example.springproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/display")
public class SpringBasics {

    @GetMapping("hello-world")
    public String displayString() {
        return "HELLO WORLD";
    }
}

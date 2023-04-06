package com.example.student;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private int id;
    private String name;
    private int age;
    private List<String> subjects;
}

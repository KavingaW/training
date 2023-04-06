package com.example.student;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        List<String> studentList= new ArrayList<>();
        studentList.add("Maths");
        studentList.add("English");
        studentList.add("History");

        student.setId(1);
        student.setName("John");
        student.setAge(20);
        student.setSubjects(studentList);

        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("Subjects: " + student.getSubjects());
    }
}

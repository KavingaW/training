package com.example.springproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudentList() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    public Student getStudentById(Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.get();
    }

    public Student createStudent(Student student) {
        Student createdStudent = studentRepository.save(student);
        return createdStudent;
    }

    public String deleteStudent(Integer id) {
        studentRepository.deleteById(id);
        return "Deleted Student with Id: " + id;
    }
}

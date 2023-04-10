package com.example.springproject.service;

import com.example.springproject.dto.StudentDto;
import com.example.springproject.dto.StudentRequestDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getStudentList();

    StudentDto getStudentById(Integer id);

    StudentDto createStudent(StudentRequestDto studentRequestDto);

    StudentDto deleteStudent(Integer id);

}

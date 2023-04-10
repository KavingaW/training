package com.example.springproject.controller;

import com.example.springproject.dto.StudentListResponseDto;
import com.example.springproject.dto.StudentRequestDto;
import com.example.springproject.dto.StudentResponseDto;
import com.example.springproject.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("/students")
    public ResponseEntity<StudentListResponseDto> getStudentList() {
        StudentListResponseDto studentResponseDto = new StudentListResponseDto();
        studentResponseDto.setCode("200");
        studentResponseDto.setMessage("OK");
        try {
            studentResponseDto.setStudentDto(studentService.getStudentList());
            return new ResponseEntity<>(studentResponseDto, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable(value = "id") Integer id) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setCode("200");
        studentResponseDto.setMessage("OK");
        try {
            studentResponseDto.setStudentDto(studentService.getStudentById(id));
            return new ResponseEntity<>(studentResponseDto, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/students")
    public ResponseEntity<StudentResponseDto> addStudent(@RequestBody StudentRequestDto studentRequestDto) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setCode("200");
        studentResponseDto.setMessage("OK");
        try {
            studentResponseDto.setStudentDto(studentService.createStudent(studentRequestDto));
            return new ResponseEntity<>(studentResponseDto, HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<StudentResponseDto> deleteStudent(@PathVariable(value = "id") Integer id) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setCode("200");
        studentResponseDto.setMessage("OK");
        try {
            studentResponseDto.setStudentDto(studentService.deleteStudent(id));
            return new ResponseEntity<>(studentResponseDto, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

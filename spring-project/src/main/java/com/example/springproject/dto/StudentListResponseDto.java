package com.example.springproject.dto;

import java.util.List;

public class StudentListResponseDto {

    private String code;
    private String message;
    private List<StudentDto> studentDto;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<StudentDto> getStudentDto() {
        return studentDto;
    }

    public void setStudentDto(List<StudentDto> studentDto) {
        this.studentDto = studentDto;
    }
}
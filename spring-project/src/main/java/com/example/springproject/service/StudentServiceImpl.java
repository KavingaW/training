package com.example.springproject.service;

import com.example.springproject.dto.StudentDto;
import com.example.springproject.dto.StudentRequestDto;
import com.example.springproject.exceptions.NotFoundException;
import com.example.springproject.model.Student;
import com.example.springproject.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    public List<StudentDto> getStudentList() {
        logger.info("Getting all students");
        List<Student> students = studentRepository.findAll();
        return students.stream().map(student -> convertToStudentDto(student)).collect(Collectors.toList());
    }

    public StudentDto getStudentById(Integer id) {
        logger.info("Getting student with id: " + id);
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return convertToStudentDto(student.get());
        } else {
            logger.error("No such student with id: " + id);
            throw new NotFoundException("Student Not Found");
        }
    }

    public StudentDto createStudent(StudentRequestDto studentRequestDto) {
        logger.info("creating student");
        Student student = convertToStudent(studentRequestDto);
        studentRepository.save(student);
        logger.info("created new student with id: " + studentRequestDto.getId());
        return convertToStudentDto(student);
    }

    public StudentDto deleteStudent(Integer id) {
        logger.info("Deleting student with id: " + id);
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            studentRepository.deleteById(id);
            logger.info("deleted student with id: "+id);
            return convertToStudentDto(student.get());
        } else {
            logger.error("No such student with id: " + id);
            throw new NotFoundException("Student Not Found");
        }
    }

    private StudentDto convertToStudentDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setDob(student.getDob());
        studentDto.setAverage(student.getAverage());
        return studentDto;
    }

    private Student convertToStudent(StudentRequestDto studentRequestDto) {

        Student student = new Student();
        student.setId(studentRequestDto.getId());
        student.setName(studentRequestDto.getName());
        student.setDob(studentRequestDto.getDob());
        student.setAverage(studentRequestDto.getAverage());
        return student;
    }
}

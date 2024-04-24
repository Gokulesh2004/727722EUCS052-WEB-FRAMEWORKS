package com.example.bidirection.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.bidirection.model.Student;
import com.example.bidirection.model.StudentInfo;
import com.example.bidirection.service.GokuleshService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class GokuleshController {
    public GokuleshService studentService;
    public GokuleshController(GokuleshService studentService)
    {
        this.studentService = studentService;
    }
    @PostMapping("/api/poststudent")
    public Student postMethodName(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }
    @PostMapping("/api/poststudentinfo")
    public StudentInfo postMethodName(@RequestBody StudentInfo studentInfo) {
        return studentService.saveStudentInfo(studentInfo);
    }
    @GetMapping("/api/student")
    public List<Student> getMethodName() {
        return studentService.getStudents();
    }
    
}
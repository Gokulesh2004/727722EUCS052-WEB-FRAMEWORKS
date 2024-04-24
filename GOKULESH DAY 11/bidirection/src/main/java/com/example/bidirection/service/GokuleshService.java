package com.example.bidirection.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bidirection.model.Student;
import com.example.bidirection.model.StudentInfo;
import com.example.bidirection.repository.GokuleshInfo;
import com.example.bidirection.repository.GokuleshRepository;

@Service
public class GokuleshService {
    public GokuleshRepository studentRepository;
    public GokuleshInfo studentInfoRepository;
    public GokuleshService(GokuleshRepository studentRepository,GokuleshInfo studentInfoRepository)
    {
        this.studentRepository = studentRepository;
        this.studentInfoRepository = studentInfoRepository;
    }
    public Student saveStudent(Student student)
    {
        return studentRepository.save(student);
    }
    public StudentInfo saveStudentInfo(StudentInfo studentInfo)
    {
        return studentInfoRepository.save(studentInfo);
    }
    public List<Student> getStudents()
    {
        return studentRepository.findAll();
    }
}

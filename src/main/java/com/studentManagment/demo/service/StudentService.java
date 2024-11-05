package com.studentManagment.demo.service;

import java.util.List;

import com.studentManagment.demo.model.Student;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudent();
    Student getStudentById(long id);
    Student updateStudent(Student student,long id);
    void deleteStudent(long id);
}
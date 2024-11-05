package com.studentManagment.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentManagment.demo.model.Student;
import com.studentManagment.demo.repo.StudentRepo;
import com.studentManagment.demo.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Override
    public Student saveStudent(Student student){
        return studentRepo.save(student);
    }
    @Override
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }
    @Override
    public Student getStudentById(long id) {
        Optional<Student> student = studentRepo.findById(id);
        if(student.isPresent()){
        return student.get();
        }else {
        throw new RuntimeException();
        }
    }
    @Override
    public Student updateStudent(Student student, long id) {
        Student existingStudent = studentRepo.findById(id).orElseThrow(
        ()-> new RuntimeException()
        );
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setYearOfEnrollment(student.getYearOfEnrollment());
        // save
        studentRepo.save(existingStudent);
        return existingStudent;

    }
    @Override
    public void deleteStudent(long id) {
        //check
        studentRepo.findById(id).orElseThrow(()-> new
        RuntimeException());
        //delete
        studentRepo.deleteById(id);
    }
}

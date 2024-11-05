package com.studentManagment.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentManagment.demo.model.Student;

public interface StudentRepo extends JpaRepository<Student,Long> {

    
}
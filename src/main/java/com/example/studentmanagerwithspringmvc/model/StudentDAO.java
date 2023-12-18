package com.example.studentmanagerwithspringmvc.model;

import com.example.studentmanagerwithspringmvc.entity.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> getAllStudent();
    Student findStudentById(int id);
}

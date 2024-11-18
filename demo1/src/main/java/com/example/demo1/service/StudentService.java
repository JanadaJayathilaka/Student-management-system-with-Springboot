package com.example.demo1.service;

import java.util.List;

import com.example.demo1.model.Student;

public interface StudentService {
    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(long id);

    Student updateStudent(Student student, long id);

    void deleteStudent(long id);

    List<Student> getStudentByYearOfEnrollment(int yearOfEnrollment);

    String getDepartmentById(Long id);

    void removeStudentByYearOfEnrollment(int yearOfEnrollment);

}

package com.example.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo1.model.Student;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByYearOfEnrollment(int yearOfEnrollment);

    @Query("SELECT s.department FROM students s WHERE s.id = :id")
    String findDepartmentById(Long id);

    @Query("DELETE FROM students s WHERE s.yearOfEnrollment = :yearOfEnrollment")
    void deleteByYearOfEnrollment(int yearOfEnrollment);

}

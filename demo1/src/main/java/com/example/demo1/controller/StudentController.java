package com.example.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.model.Student;
import com.example.demo1.service.StudentService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/students")

public class StudentController {

    @Autowired

    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentId) {
        return new ResponseEntity<>(studentService.getStudentById(studentId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
        return new ResponseEntity<>(studentService.updateStudent(student, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/yearOfEnrollment/{yearOfEnrollment}")
    public ResponseEntity<List<Student>> getStudentByYearOfEnrollment(@PathVariable int yearOfEnrollment) {
        List<Student> students = studentService.getStudentByYearOfEnrollment(yearOfEnrollment);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<String> getDepartmentById(@PathVariable Long id) {
        String departmentName = studentService.getDepartmentById(id);
        if (departmentName != null) {
            return new ResponseEntity<String>(departmentName, HttpStatus.OK);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/removeStudent/{yearOfEnrollment}")
    public ResponseEntity<String> deleteStudentByYearOfEnrollment(@PathVariable int yearOfEnrollment) {
        studentService.removeStudentByYearOfEnrollment(yearOfEnrollment);
        return ResponseEntity.ok("Student enrolled in" + yearOfEnrollment + "have been removed.");
    }

}

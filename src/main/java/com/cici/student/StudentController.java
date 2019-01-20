package com.cici.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;


    @RequestMapping(value = "/student/{id}")
    public Student getStudent(@PathVariable int id) {
        return studentRepository.getStudent(id);


    }


    @RequestMapping(value = "/students")
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();



    }
    @PostMapping(value = "/student")
    public void addStudent(@RequestBody Student student){
        studentRepository.addStudent(student);
    }

    @PostMapping(value="/update/student")
    public void updateStudent(@RequestBody Student student){
        studentRepository.updateStudent(student);
    }

    @DeleteMapping(value="/student/{id}")
    public void deleteStudent(@PathVariable int id ){
        studentRepository.deleteStudent(id);
    }
}

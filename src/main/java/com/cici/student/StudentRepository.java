package com.cici.student;

import java.util.List;

public interface StudentRepository {
    public Student getStudent(int id);
    public List<Student> getAllStudents();

    public void addStudent(Student student);


    public void updateStudent(Student student);

    public void deleteStudent(int id);
}

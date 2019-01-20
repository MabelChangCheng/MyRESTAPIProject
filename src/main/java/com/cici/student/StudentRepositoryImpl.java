package com.cici.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
import java.util.List;

//the same as StudentDAOImpl
@Service //能够Autowired的一个表示
public class StudentRepositoryImpl implements StudentRepository {


    //entity manager helps you to connect database and get data

    @Autowired
    private EntityManager em;
    @Override
    public Student getStudent(int id) {

        //HQL - Hibernate query language, simillar to SQL
        //cannot use *, every table name and attribut must be the same as model
        Student s = em.createQuery("SELECT s from Student s where s.studentId =" + id, Student.class).getSingleResult();
        return s;
    }
    @Override
    public List<Student> getAllStudents(){
        List<Student> list = em.createQuery("SELECT s from Student s", Student.class).getResultList();

        return list;
    }

    @Override
    @Transactional   //insert update post都要加
    public void addStudent(Student student) {
        em.persist(student);

    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        em.merge(student);

    }
    @Override
    @Transactional
    public void deleteStudent(int id) {
        Student s = getStudent(id);
        em.remove(s);

    }
}

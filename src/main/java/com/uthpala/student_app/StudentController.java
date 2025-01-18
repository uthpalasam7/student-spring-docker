package com.uthpala.student_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepo repo;
    @RequestMapping("/getStudents")
    public List<Student> getStudents() {
        return repo.findAll();
    }

    @RequestMapping("/addStudent")
    public Student addStudent() {
        Student s = new Student();
        s.setName("Ravi");
        s.setAge(25);
        return repo.save(s);
    }
}

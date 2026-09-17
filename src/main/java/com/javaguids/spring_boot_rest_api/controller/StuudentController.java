package com.javaguids.spring_boot_rest_api.controller;
import java.util.ArrayList;
import java.util.List;
import com.javaguids.spring_boot_rest_api.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class StuudentController {

    //http://localhost:8081/student
    @GetMapping("student")
    public Student getStudent(){
        Student student =new Student(
                1,
                "sivakrishna",
                "bandaru"
        );
        return student;
    }

    //http://localhost:8081/students
    @GetMapping("students")
    public List<Student>  getStudents(){
        List<Student> students=new ArrayList<>();
        students.add(new Student(1,"basha","shaik"));
        students.add(new Student(2,"raja","googletuth"));
        students.add(new Student(2,"koti","sattenapalli"));
        return students;
    }

    //Spring Boot REST API with Path Variable
    //this {id} is called URI template variable
    //http://localhost:8081/students/1
    @GetMapping("students/{id}/{firstname}/{lastname}")
    public Student studentPathVarisble(@PathVariable int id,@PathVariable String firstname,@PathVariable String lastname){
        return new Student(id,firstname,lastname);
    }
}

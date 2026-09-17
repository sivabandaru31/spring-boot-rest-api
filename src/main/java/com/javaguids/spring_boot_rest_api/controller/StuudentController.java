package com.javaguids.spring_boot_rest_api.controller;
import java.util.ArrayList;
import java.util.List;
import com.javaguids.spring_boot_rest_api.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping("students")
    public List<Student>  getStudents(){
        List<Student> students=new ArrayList<>();
        students.add(new Student(1,"basha","shaik"));
        students.add(new Student(2,"raja","googletuth"));
        students.add(new Student(2,"koti","sattenapalli"));
        return students;
    }

}

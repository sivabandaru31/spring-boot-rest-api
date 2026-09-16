package com.javaguids.spring_boot_rest_api.controller;

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

}

package com.javaguids.spring_boot_rest_api.controller;
import java.util.ArrayList;
import java.util.List;
import com.javaguids.spring_boot_rest_api.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    //spring boot rest api with Request param
    //http://localhost:8081/students/query?id=1&firstName=sivakrishna&lastName=bandaru
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam  String firstName,
                                          @RequestParam String lastName){
        return new Student(id,firstName,lastName);
    }

    //SPRING BOOT REST API THAT HANDLE HTTP POST REQUEST-to creating new resource
    //@PostMapping && @RequestBody

    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstname());
        System.out.println(student.getLastname());
        return student ;
    }

    //Spring boot REST API thst handles HTTP PUT Request-updating existing resourse
    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student students,@PathVariable("id") int studentId){
        System.out.println(students.getFirstname());
        System.out.println(students.getLastname());
        return students;
    }
}

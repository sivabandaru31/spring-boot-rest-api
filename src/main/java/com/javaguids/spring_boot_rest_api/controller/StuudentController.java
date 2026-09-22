package com.javaguids.spring_boot_rest_api.controller;
import java.util.ArrayList;
import java.util.List;
import com.javaguids.spring_boot_rest_api.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("students")

public class StuudentController {

    //http://localhost:8081/student-without response entity
//    @GetMapping("student")
//    public Student getStudent(){
//        Student student =new Student(
//                1,
//                "sivakrishna",
//                "bandaru"
//        );
//        return student;
//    }

    //with response entity
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student =new Student(
                1,
                "sivakrishna",
                "bandaru"
        );
        //return new ResponseEntity<>(student,HttpStatus.OK);
        return ResponseEntity.ok().header("custom-header","sivakrishna")
                .body(student);
    }

    //http://localhost:8081/students
    @GetMapping
    public ResponseEntity<List<Student>>  getStudents(){
        List<Student> students=new ArrayList<>();
        students.add(new Student(1,"basha","shaik"));
        students.add(new Student(2,"raja","googletuth"));
        students.add(new Student(2,"koti","sattenapalli"));
        return ResponseEntity.ok(students);
    }

    //Spring Boot REST API with Path Variable
    //this {id} is called URI template variable
    //http://localhost:8081/students/1
    @GetMapping("/{id}/{firstname}/{lastname}")
    public ResponseEntity<Student> studentPathVarisble(@PathVariable int id,@PathVariable String firstname,@PathVariable String lastname){
        //return new Student(id,firstname,lastname);
        Student student=new Student(id,firstname,lastname);
        return ResponseEntity.ok(student);
    }

    //spring boot rest api with Request param
    //http://localhost:8081/students/query?id=1&firstName=sivakrishna&lastName=bandaru
    @GetMapping("/query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam  String firstName,
                                          @RequestParam String lastName){
        Student student=new Student(id,firstName,lastName);
        return ResponseEntity.ok(student);
    }

    //SPRING BOOT REST API THAT HANDLE HTTP POST REQUEST-to creating new resource
    //@PostMapping && @RequestBody

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstname());
        System.out.println(student.getLastname());
        //return student ;
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }

    //Spring boot REST API thst handles HTTP PUT Request-updating existing resourse
    @PutMapping("/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student students,@PathVariable("id") int studentId){
        System.out.println(students.getFirstname());
        System.out.println(students.getLastname());
        return ResponseEntity.ok(students);
    }
    //Spring boot REST API that Handles HTTP Delete Request-deleting existing resource
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("student delete successfully!");
    }
    }

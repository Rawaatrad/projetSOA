package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class StudentController {
    @Autowired
    StudentRepo studentRepo;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }
    //create student
    @PostMapping("/student")
    public  Student createStudent(@RequestBody Student student){
        return studentRepo.save(student);
    }
    //get student by id
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentRepo.findById(id).get();
    }

    //update employee
    @PutMapping("/students/{id}")
    public  Student updateStudent(@PathVariable Long id, @RequestBody Student student){
        Student student1 = studentRepo.findById(id).get();

        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setLevel(student.getLevel());
        student1.setCarteId(student.getCarteId());
        student1.setEmail(student.getEmail());
        return studentRepo.save(student1);

    }
    //delete employee
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id){
        Student student = studentRepo.findById(id).get();
        studentRepo.delete(student);
    }


}

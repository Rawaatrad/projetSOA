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
    public List<Emprunt> getAllStudents(){
        return studentRepo.findAll();
    }
    //create student
    @PostMapping("/student")
    public Emprunt createStudent(@RequestBody Emprunt emprunt){
        return studentRepo.save(emprunt);
    }
    //get student by id
    @GetMapping("/students/{id}")
    public Emprunt getStudentById(@PathVariable Long id){
        return studentRepo.findById(id).get();
    }

    //update employee
    @PutMapping("/students/{id}")
    public Emprunt updateStudent(@PathVariable Long id, @RequestBody Emprunt emprunt){
        Emprunt emprunt1 = studentRepo.findById(id).get();

        emprunt1.setFirstName(emprunt.getFirstName());
        emprunt1.setLastName(emprunt.getLastName());
        emprunt1.setLevel(emprunt.getLevel());
        emprunt1.setCarteId(emprunt.getCarteId());
        emprunt1.setEmail(emprunt.getEmail());
        return studentRepo.save(emprunt1);

    }
    //delete employee
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id){
        Emprunt emprunt = studentRepo.findById(id).get();
        studentRepo.delete(emprunt);
    }


}

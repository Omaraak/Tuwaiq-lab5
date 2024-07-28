package com.example.day21.Controller;

import com.example.day21.Model.StudentModel;
import com.example.day21.Response.Response;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("lab5/q1")
public class StudentController {
    ArrayList<StudentModel> students = new ArrayList<>();

    @GetMapping("/name/{id}")
    public Response name(@PathVariable String id){
        for(StudentModel student : students){
            if(student.getId().equals(id)){
                return new Response(student.getName());
            }
        }
        return new Response("Not found");
    }

    @GetMapping("/age/{id}")
    public int age(@PathVariable String id){
        for(StudentModel student : students){
            if(student.getId().equals(id)){
                return student.getAge();
            }
        }
        return -1;
    }

    @GetMapping("/college/degree/{id}")
    public Response degree(@PathVariable String id){
        for(StudentModel student : students){
            if(student.getId().equals(id)){
                return new Response(student.getDegree());
            }
        }
        return new Response("Not found");
    }

    @GetMapping("/study/status/{id}")
    public Response degreeStatus(@PathVariable String id){
        for(StudentModel student : students){
            if(student.getId().equals(id)) {
                if (student.getStatus().equals("graduated")) {
                    return new Response("True");
                } else {
                    return new Response("False");
                }
            }
        }
        return new Response("Not found");
    }

    @GetMapping("/students")
    public ArrayList<StudentModel> students() {
        return students;
    }

    @PostMapping("/add")
    public Response addStudent(@RequestBody StudentModel student) {
        students.add(student);
        return new Response("Added");
    }

    @PutMapping("/update/{index}")
    public Response updateStudent(@PathVariable int index, @RequestBody StudentModel student) {
        if (index < students.size()) {
            students.set(index, student);
            return new Response("Updated");
        }
        return new Response("Not found");
    }

    @DeleteMapping("/delete/{index}")
    public Response deleteStudent(@PathVariable int index) {
        if (index < students.size()) {
            students.remove(index);
            return new Response("Deleted");
        }
        return new Response("Not found");
    }
}

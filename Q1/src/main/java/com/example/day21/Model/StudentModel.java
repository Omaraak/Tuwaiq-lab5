package com.example.day21.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentModel {
    private String id,name,degree,status;
    private int age;
}

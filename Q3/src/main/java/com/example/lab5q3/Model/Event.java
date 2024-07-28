package com.example.lab5q3.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Event {
    private int id, capacity;
    private String description;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate startDate,endDate;
}

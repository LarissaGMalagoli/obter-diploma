package com.grupo3.obterdiploma.controller.dto;


import com.grupo3.obterdiploma.model.Student;
import lombok.Getter;


@Getter
public class DegreeDto {

    private final String message;
    private final double average;
    private final StudentDto student;


    public DegreeDto(Student student, String message, double average){
        this.message = message;
        this.average = average;
        this.student = new StudentDto(student);
    }


}

package com.grupo3.obterdiploma.service;

import com.grupo3.obterdiploma.controller.dto.DegreeDto;
import com.grupo3.obterdiploma.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentDtoService {

    @Autowired
    StudentMeanService studentMeanService;

    public DegreeDto convertToDto(Student student){

        double average = studentMeanService.studentMean(student);

        String message = String.format("Sua média foi de %.2f",  average);

        if (average > 9){
            message = "Parabéns!!! " + message;
        }

        return new DegreeDto(student, message, average);
    }
}

package com.grupo3.obterdiploma.service;

import com.grupo3.obterdiploma.exception.SubjectNotFoundException;
import com.grupo3.obterdiploma.model.Student;
import com.grupo3.obterdiploma.model.Subject;
import org.springframework.stereotype.Service;

import java.util.OptionalDouble;

@Service
public class StudentMeanService {

    public double studentMean (Student student){
        OptionalDouble notaOptional = student.getSubjectList().stream().mapToDouble(Subject::getNota).average();
        if(notaOptional.isEmpty()){
            throw new SubjectNotFoundException("Não existem matérias cadastradas no usuário");
        }
        return notaOptional.getAsDouble();
    }
}

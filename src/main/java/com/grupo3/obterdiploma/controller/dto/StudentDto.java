package com.grupo3.obterdiploma.controller.dto;

import com.grupo3.obterdiploma.model.Student;
import lombok.Getter;

import java.util.List;

@Getter
public class StudentDto {

    private final String nome;
    private final List<SubjectDto> subjectList;

    public StudentDto(Student student){
        this.nome= student.getNome();
        this.subjectList = SubjectDto.convert(student.getSubjectList());
    }
}

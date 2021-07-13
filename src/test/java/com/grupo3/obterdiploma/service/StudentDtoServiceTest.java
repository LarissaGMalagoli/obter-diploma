package com.grupo3.obterdiploma.service;

import com.grupo3.obterdiploma.controller.dto.DegreeDto;
import com.grupo3.obterdiploma.model.Student;
import com.grupo3.obterdiploma.model.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentDtoServiceTest {

    @Autowired
    StudentDtoService studentDtoService;

    @Test
    public void deveConterAPalavraParabensNaMensagem(){
        List<Subject> subjects = new ArrayList<>();
        Subject materia1 = new Subject("matematica", 10);
        Subject materia2 = new Subject("portugues", 10);
        subjects.add(materia1);
        subjects.add(materia2);
        Student student = new Student("aluno1", subjects);

        DegreeDto degreeDto = studentDtoService.convertToDto(student);

        assertTrue(degreeDto.getMessage().contains("Parabéns"));

    }

    @Test
    public void naoDeveConterAPalavraParabensNaMensagem(){
        List<Subject> subjects = new ArrayList<>();
        Subject materia1 = new Subject("matematica", 3);
        Subject materia2 = new Subject("portugues", 3);
        subjects.add(materia1);
        subjects.add(materia2);
        Student student = new Student("aluno1", subjects);

        DegreeDto degreeDto = studentDtoService.convertToDto(student);

        assertFalse(degreeDto.getMessage().contains("Parabéns"));

    }

}
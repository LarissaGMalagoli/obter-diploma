package com.grupo3.obterdiploma.service;

import com.grupo3.obterdiploma.exception.SubjectNotFoundException;
import com.grupo3.obterdiploma.model.Student;
import com.grupo3.obterdiploma.model.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentMeanServiceTest {
    private List<Subject> subjects;
    private Student student;

    @Autowired
    private StudentMeanService studentMeanService;



    @BeforeEach
    void setUp() {
        subjects = new ArrayList<>();
        Subject materia1 = new Subject("matematica", 10);
        Subject materia2 = new Subject("portugues", 10);
        subjects.add(materia1);
        subjects.add(materia2);
        student = new Student("aluno1", subjects);
    }

    @Test
    void DeveRetornarValorDaMediaIgualADez() {
        double expected = 10.0;
        assertEquals(expected, studentMeanService.studentMean(student));
    }

    @Test
    void deveRetornarUmaExcecao(){
        Student student = new Student("aluno1", new ArrayList<>());

        assertThrows(SubjectNotFoundException.class, () -> studentMeanService.studentMean(student));

    }




}
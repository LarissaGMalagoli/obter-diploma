package com.grupo3.obterdiploma.controller.form;

import com.grupo3.obterdiploma.model.Student;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.util.List;


@Setter
public class StudentForm {
    @NotNull(message = "Nome do aluno é obrigatório!")
    @NotEmpty(message = "Nome do aluno não pode ser vazio")
    @Size(min = 8, max = 50, message = "Nome do aluno deve ter entre 8 e 50 caracteres!")
    @Pattern(regexp = "^[\\p{L} .'-]+$", message = "Nome do aluno deve ter apenas letras!")
    private String nome;
    @NotNull
    private List<SubjectForm> disciplinas;


    public Student convert() {
        Student student = new Student(this.nome);
        student.setSubjectList(SubjectForm.converteLista(this.disciplinas));
        return student;
    }
}

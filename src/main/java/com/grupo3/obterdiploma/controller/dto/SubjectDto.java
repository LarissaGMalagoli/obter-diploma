package com.grupo3.obterdiploma.controller.dto;

import lombok.Getter;
import com.grupo3.obterdiploma.model.Subject;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class SubjectDto {
    private String nome;
    private double nota;

    public SubjectDto(Subject subject){
        this.nome=subject.getNome();
        this.nota= subject.getNota();
    }

    public static List<SubjectDto> convert(List<Subject> dto){
        return dto.stream().map(SubjectDto::new).collect(Collectors.toList());
    }
}

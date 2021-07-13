package com.grupo3.obterdiploma.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Subject> subjectList;

    public Student() {
    }

    public Student(String nome, List<Subject> subjectList) {
        this.nome = nome;
        this.subjectList = subjectList;
    }

    public Student(String nome) {
        this.nome = nome;
    }
}

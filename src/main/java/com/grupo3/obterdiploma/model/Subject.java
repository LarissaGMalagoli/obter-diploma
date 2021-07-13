package com.grupo3.obterdiploma.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Subject {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    double nota;

    public Subject() {
    }

    public Subject(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }
}

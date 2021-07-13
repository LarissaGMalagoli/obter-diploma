package com.grupo3.obterdiploma.controller.form;

import com.grupo3.obterdiploma.model.Subject;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.util.List;
import java.util.stream.*;

@Setter
@Getter
public class SubjectForm {
    @NotNull(message = "Nome da matéria é obrigatório!")
    @Size(min = 8, max = 50, message = "Nome da matéria deve ter entre 8 e 50 caracteres!")
    @Pattern(regexp = "^[\\p{L} .'-]+$", message = "Nome da matéria deve ter apenas letras!")
    private  String nome;
    @NotNull(message = "Nota é obrigatório!")
    @Size(min = 1, max = 2, message = "Nota deve ter entre 1 e 2 caracteres!")
    @Pattern(regexp = "^[0-9]", message = "Nota deve ter apenas números!")
    private  double nota;

    public SubjectForm(String nome, double nota){
        this.nome = nome;
        this.nota = nota;
    }

    public Subject convert() {
        return new Subject(nome, nota);
    }

    public static List<Subject> converteLista(List<SubjectForm> forms){
        return forms.stream().map(e -> new Subject(e.getNome(), e.getNota())).collect(Collectors.toList());
    }
}

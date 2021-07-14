package com.grupo3.obterdiploma.controller;


import com.grupo3.obterdiploma.controller.dto.DegreeDto;
import com.grupo3.obterdiploma.controller.form.StudentForm;
import com.grupo3.obterdiploma.exception.StudentNotFoundException;
import com.grupo3.obterdiploma.model.Student;
import com.grupo3.obterdiploma.repository.StudentRepository;
import com.grupo3.obterdiploma.service.StudentDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping
public class Controller {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentDtoService studentDtoService;

    @GetMapping("/{id}")
    public ResponseEntity<DegreeDto> getAluno(@PathVariable Long id) {
        Optional<Student> optionalAluno = studentRepository.findById(id);
        if (optionalAluno.isEmpty()){
            throw new StudentNotFoundException("Nao existe nenhum aluno cadastrado com esse id");
        }

        return ResponseEntity.ok(studentDtoService.convertToDto(optionalAluno.get()));
    }

    @Transactional
    @PostMapping("/analyzeNotes")
    public ResponseEntity<DegreeDto> cadastrar(@RequestBody @Valid StudentForm studentForm, UriComponentsBuilder uriBuilder){
        Student student = studentForm.convert();
        studentRepository.save(student);

        URI uri = uriBuilder.path("/{id}").buildAndExpand(student.getId()).toUri();

        return ResponseEntity.created(uri).body(studentDtoService.convertToDto(student));
    }

}

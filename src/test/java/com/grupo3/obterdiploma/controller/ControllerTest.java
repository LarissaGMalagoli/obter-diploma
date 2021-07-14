package com.grupo3.obterdiploma.controller;

import com.grupo3.obterdiploma.model.Student;
import com.grupo3.obterdiploma.model.Subject;
import com.grupo3.obterdiploma.repository.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
//@DataJpaTest
class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentRepository studentRepository;

   // @BeforeEach
  //  private void init() {
  //      studentRepository.deleteAll();
  //  }

    @AfterEach
    void tearDown() {
        studentRepository.deleteAll();
    }

    @Test
    void deveRetornarStatusCode200CasoExistaAlunoCadastrado() throws Exception {
        List<Subject> subjects = new ArrayList<>();
        Subject materia1 = new Subject("matematica", 10);
        Subject materia2 = new Subject("portugues", 10);
        subjects.add(materia1);
        subjects.add(materia2);
        Student student = new Student("alunooooooo", subjects);
        studentRepository.save(student);

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/{id}",  student.getId()))
                .andExpect(MockMvcResultMatchers
                        .status().isOk());
    }

    @Test
    void deveRetornarStatusCode201CasoOsDadosEstejamCorretos() throws Exception {
        URI uri = new URI("/analyzeNotes");
        String json = "{\n" +
                "    \"nome\": \"Marcossssssssssssssssssss\",\n" +
                "    \"disciplinas\": [\n" +
                "        {\n" +
                "            \"nome\": \"Matematica\",\n" +
                "            \"nota\": 10\n" +
                "        },\n" +
                "        {\n" +
                "            \"nome\": \"Portugues\",\n" +
                "            \"nota\": 2\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(201));
    }




    @Test
    void deveRetornarExceptionCasoNaoExistaAlunoCadastrado() throws Exception {

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().isNotFound());
    }

}

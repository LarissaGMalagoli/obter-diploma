package com.grupo3.obterdiploma.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

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
}
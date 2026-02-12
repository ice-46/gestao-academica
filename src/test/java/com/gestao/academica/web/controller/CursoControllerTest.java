package com.gestao.academica.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestao.academica.application.service.CursoService;
import com.gestao.academica.domain.model.Curso;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CursoController.class)
class CursoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CursoService cursoService;

    @Test
    void deveListarCursos() throws Exception {
        Curso curso = new Curso("Sistemas", "Noite");
        curso.setId(1L);
        when(cursoService.listarCursos()).thenReturn(List.of(curso));

        mockMvc.perform(get("/api/cursos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Sistemas"));
    }

    @Test
    void deveCriarCurso() throws Exception {
        Curso curso = new Curso("Engenharia", "Integral");
        curso.setId(4L);
        when(cursoService.criarCurso(anyString(), anyString())).thenReturn(curso);

        mockMvc.perform(post("/api/cursos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new Payload("Engenharia", "Integral"))))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(4));
    }

    @Test
    void deveRetornar404QuandoNaoEncontrarParaDelete() throws Exception {
        doThrow(new EntityNotFoundException("Curso não encontrado")).when(cursoService).removerCurso(anyLong());

        mockMvc.perform(delete("/api/cursos/99"))
                .andExpect(status().isNotFound());
    }

    private record Payload(String nome, String turnos) {}
}

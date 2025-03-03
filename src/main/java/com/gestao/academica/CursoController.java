package com.gestao.academica;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @GetMapping
    public List<Curso> listarCursos() {
        // Simulação de lista vazia por enquanto
        return Collections.emptyList();
    }
}
package com.gestao.academica.web.controller;

import com.gestao.academica.application.service.CursoService;
import com.gestao.academica.domain.model.Curso;
import com.gestao.academica.web.dto.CursoRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public List<Curso> listarCursos() {
        return cursoService.listarCursos();
    }

    @GetMapping("/{id}")
    public Curso buscarPorId(@PathVariable Long id) {
        return cursoService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Curso criarCurso(@Valid @RequestBody CursoRequest request) {
        return cursoService.criarCurso(request.nome(), request.turnos());
    }

    @PutMapping("/{id}")
    public Curso atualizarCurso(@PathVariable Long id, @Valid @RequestBody CursoRequest request) {
        return cursoService.atualizarCurso(id, request.nome(), request.turnos());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCurso(@PathVariable Long id) {
        cursoService.removerCurso(id);
    }
}

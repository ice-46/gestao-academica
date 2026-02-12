package com.gestao.academica.application.service;

import com.gestao.academica.domain.model.Curso;
import com.gestao.academica.domain.repository.CursoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    public Curso buscarPorId(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado para id=" + id));
    }

    public Curso criarCurso(String nome, String turnos) {
        return cursoRepository.save(new Curso(nome, turnos));
    }

    public Curso atualizarCurso(Long id, String nome, String turnos) {
        Curso curso = buscarPorId(id);
        curso.setNome(nome);
        curso.setTurnos(turnos);
        return cursoRepository.save(curso);
    }

    public void removerCurso(Long id) {
        Curso curso = buscarPorId(id);
        cursoRepository.delete(curso);
    }

    public boolean possuiCursosCadastrados() {
        return cursoRepository.count() > 0;
    }
}

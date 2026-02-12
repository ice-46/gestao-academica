package com.gestao.academica.application.service;

import com.gestao.academica.domain.model.Curso;
import com.gestao.academica.domain.repository.CursoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CursoServiceTest {

    @Mock
    private CursoRepository cursoRepository;

    @InjectMocks
    private CursoService cursoService;

    @Test
    void deveListarCursos() {
        Curso curso = new Curso("ADS", "Noite");
        when(cursoRepository.findAll()).thenReturn(List.of(curso));

        List<Curso> cursos = cursoService.listarCursos();

        assertEquals(1, cursos.size());
        assertEquals("ADS", cursos.getFirst().getNome());
    }

    @Test
    void deveLancarExcecaoQuandoCursoNaoEncontrado() {
        when(cursoRepository.findById(10L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> cursoService.buscarPorId(10L));
    }

    @Test
    void deveRemoverCursoExistente() {
        Curso curso = new Curso("Direito", "Tarde");
        curso.setId(3L);
        when(cursoRepository.findById(3L)).thenReturn(Optional.of(curso));

        cursoService.removerCurso(3L);

        verify(cursoRepository).delete(curso);
    }
}

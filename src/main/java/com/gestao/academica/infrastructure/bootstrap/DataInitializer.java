package com.gestao.academica.infrastructure.bootstrap;

import com.gestao.academica.application.service.CursoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CursoService cursoService;

    public DataInitializer(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @Override
    public void run(String... args) {
        if (cursoService.possuiCursosCadastrados()) {
            return;
        }

        cursoService.criarCurso("Ciência da Computação", "Manhã, Noite");
        cursoService.criarCurso("Administração", "Tarde");
    }
}

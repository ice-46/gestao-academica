package com.gestao.academica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void run(String... args) throws Exception {
        Curso curso1 = new Curso();
        curso1.setNome("Ciência da Computação");
        curso1.setTurnos("Manhã, Noite");
        cursoRepository.save(curso1);

        Curso curso2 = new Curso();
        curso2.setNome("Administração");
        curso2.setTurnos("Tarde");
        cursoRepository.save(curso2);
    }
}
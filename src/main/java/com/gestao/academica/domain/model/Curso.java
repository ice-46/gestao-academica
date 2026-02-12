package com.gestao.academica.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String turnos;

    public Curso() {
    }

    public Curso(String nome, String turnos) {
        this.nome = nome;
        this.turnos = turnos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurnos() {
        return turnos;
    }

    public void setTurnos(String turnos) {
        this.turnos = turnos;
    }
}

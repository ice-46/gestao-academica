package com.gestao.academica.web.dto;

import jakarta.validation.constraints.NotBlank;

public record CursoRequest(
        @NotBlank(message = "Nome é obrigatório") String nome,
        @NotBlank(message = "Turnos é obrigatório") String turnos
) {
}

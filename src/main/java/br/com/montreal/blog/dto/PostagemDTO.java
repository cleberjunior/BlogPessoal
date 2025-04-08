package br.com.montreal.blog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PostagemDTO(
        @NotBlank
        String titulo,

        @NotBlank
        String texto,

        @NotNull
        Long temaId,

        @NotNull
        Long usuarioId) {
}

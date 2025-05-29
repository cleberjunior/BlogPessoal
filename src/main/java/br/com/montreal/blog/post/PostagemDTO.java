package br.com.montreal.blog.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record PostagemDTO(
        @NotBlank
        @Size(min = 10, max = 255)
        String titulo,

        @NotBlank
        @Size(min = 10, max = 1000)
        String conteudo,

        @NotBlank
        @Size(min = 10, max = 255)
        String autor,

        LocalDateTime criadoEm,

        @NotNull
        Long temaId,

        @NotNull
        Long usuarioId) {
}

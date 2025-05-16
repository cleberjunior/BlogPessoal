package br.com.montreal.blog.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PostagemDTO(
        Long id,

        @NotBlank
        @Size(min = 10, max = 255)
        String titulo,

        @NotBlank
        @Size(min = 10, max = 1000)
        String texto,

        @NotNull
        Long temaId,

        @NotNull
        Long usuarioId) {
}

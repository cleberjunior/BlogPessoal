package br.com.montreal.blog.tema;

import jakarta.validation.constraints.NotBlank;

public record TemaDTO(
        @NotBlank
        String descricao
) {
}

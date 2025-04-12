package br.com.montreal.blog.post;

import jakarta.validation.constraints.NotBlank;

public record TemaDTO(@NotBlank String descricao) {
}

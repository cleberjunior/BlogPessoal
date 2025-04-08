package br.com.montreal.blog.dto;

import jakarta.validation.constraints.NotBlank;

public record TemaDTO(@NotBlank String descricao) {
}

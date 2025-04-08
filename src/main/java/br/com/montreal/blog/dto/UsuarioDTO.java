package br.com.montreal.blog.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @Min(value = 6)
        String senha,

        String foto) {
}

package br.com.montreal.blog.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioDTO(
        Long id,

        @NotBlank
        @Size(min = 3, max = 255)
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Size(min = 6, max = 12)
        String senha,

        @Size(max = 255)
        String foto) {
}

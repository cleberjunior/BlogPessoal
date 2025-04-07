package br.com.montreal.blog.dto;

public record UsuarioLoginDTO(String nome,
                              String email,
                              String senha,
                              String foto,
                              String token
) {
}

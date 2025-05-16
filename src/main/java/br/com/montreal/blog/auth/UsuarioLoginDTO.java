package br.com.montreal.blog.auth;

public record UsuarioLoginDTO(
    String email,
    String senha) {
}

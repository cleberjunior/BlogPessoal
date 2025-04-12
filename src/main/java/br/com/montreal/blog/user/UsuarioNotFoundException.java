package br.com.montreal.blog.user;

public class UsuarioNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public UsuarioNotFoundException(Long id) {
        super("Usuário não encontrado com o id: " + id);
    }

    public UsuarioNotFoundException(String email) {
        super("Usuário não encontrado com o email: " + email);
    }

}

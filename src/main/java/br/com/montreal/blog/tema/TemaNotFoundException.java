package br.com.montreal.blog.tema;

public class TemaNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TemaNotFoundException(Long id) {
        super("Tema não encontrado com o id: " + id);
    }

}

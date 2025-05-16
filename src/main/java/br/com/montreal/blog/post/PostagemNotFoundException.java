package br.com.montreal.blog.post;

public class PostagemNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PostagemNotFoundException(Long id) {
        super("Postagem não encontrada com o id: " + id);
    }

}

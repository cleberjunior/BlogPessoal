package br.com.montreal.blog.post;

public class PostagemMapper {

    private PostagemMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static PostagemEntity toEntity(PostagemDTO dto) {
        return new PostagemEntity(dto.titulo(), dto.conteudo(), dto.autor(), dto.temaId(), dto.usuarioId());
    }

    public static PostagemDTO toDTO(PostagemEntity entity) {
        return new PostagemDTO(
                entity.getId(),
                entity.getTitulo(),
                entity.getConteudo(),
                entity.getAutor(),
                entity.getCriadoEm(),
                entity.getTema().getId(),
                entity.getUsuario().getId());
    }
}

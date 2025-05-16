package br.com.montreal.blog.tema;

public class TemaMapper {

    private TemaMapper(){
        throw new IllegalStateException("Utility class");
    }

    public static TemaEntity toEntity(TemaDTO dto) {
        TemaEntity entity = new TemaEntity();
        entity.setDescricao(dto.descricao());
        return entity;
    }

    public static TemaDTO toDTO(TemaEntity entity) {
        return new TemaDTO(entity.getDescricao());
    }
}

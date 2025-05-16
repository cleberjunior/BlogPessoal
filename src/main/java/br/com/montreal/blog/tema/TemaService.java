package br.com.montreal.blog.tema;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TemaService {

    private final TemaRepository repository;

    public TemaDTO criar(TemaDTO temaDTO) {
        TemaEntity novoTema = TemaMapper.toEntity(temaDTO);
        TemaEntity temaCriado = repository.save(novoTema);
        return TemaMapper.toDTO(temaCriado);
    }

    public TemaDTO atualizar(Long id, TemaDTO temaDTO) {
        TemaEntity tema = repository.findById(id)
                .orElseThrow(() -> new TemaNotFoundException(id));

        tema.setDescricao(temaDTO.descricao());
        return TemaMapper.toDTO(repository.save(tema));
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public List<TemaDTO> listarTodos(){
        return repository.findAll()
                .stream()
                .map(TemaMapper::toDTO)
                .toList();
    }

    public TemaDTO buscarById(Long id) {
        return TemaMapper.toDTO(repository.findById(id)
                .orElseThrow(() -> new TemaNotFoundException(id)));
    }
}

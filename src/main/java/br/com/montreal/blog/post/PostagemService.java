package br.com.montreal.blog.post;

import java.time.LocalDateTime;
import java.util.List;

import br.com.montreal.blog.tema.TemaEntity;
import br.com.montreal.blog.tema.TemaNotFoundException;
import br.com.montreal.blog.tema.TemaRepository;
import org.springframework.stereotype.Service;
import br.com.montreal.blog.user.UsuarioNotFoundException;
import br.com.montreal.blog.user.UsuarioRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostagemService {

    @NonNull
    private final PostagemRepository postagemRepository;

    @NonNull
    private final TemaRepository temaRepository;

    @NonNull
    private final UsuarioRepository usuarioRepository;

    public PostagemDTO criar(PostagemDTO dto) {
        if (!usuarioRepository.existsById(dto.usuarioId())) {
            throw new UsuarioNotFoundException(dto.usuarioId());
        }

        if (!temaRepository.existsById(dto.temaId())) {
            throw new TemaNotFoundException(dto.temaId());
        }

        PostagemEntity novaPostagem = PostagemMapper.toEntity(dto);
        PostagemEntity postagemCriada = postagemRepository.save(novaPostagem);

        return PostagemMapper.toDTO(postagemCriada);
    }

    public PostagemDTO atualizar(Long id, PostagemDTO dto) {
        PostagemEntity postagem = postagemRepository.findById(id)
                .orElseThrow(() -> new PostagemNotFoundException(id));

        TemaEntity tema = temaRepository.findById(dto.temaId())
                .orElseThrow(() -> new TemaNotFoundException(dto.temaId()));

        postagem.setTitulo(dto.titulo());
        postagem.setConteudo(dto.conteudo());
        postagem.setAutor(dto.autor());
        postagem.setTema(tema);

        return PostagemMapper.toDTO(postagemRepository.save(postagem));
    }

    public void excluir(Long id) {
        postagemRepository.deleteById(id);
    }

    public List<PostagemDTO> listarTodos(){
        return postagemRepository.findAll()
                .stream()
                .map(PostagemMapper::toDTO)
                .toList();
    }

    public PostagemDTO buscarPorId(Long id) {
        PostagemEntity postagem = postagemRepository.findById(id)
                .orElseThrow(() -> new PostagemNotFoundException(id));

        return PostagemMapper.toDTO(postagem);
    }
}

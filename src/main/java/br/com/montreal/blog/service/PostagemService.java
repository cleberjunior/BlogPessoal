package br.com.montreal.blog.service;

import br.com.montreal.blog.dto.PostagemDTO;
import br.com.montreal.blog.model.Postagem;
import br.com.montreal.blog.model.Tema;
import br.com.montreal.blog.model.Usuario;
import br.com.montreal.blog.repository.PostagemRepository;
import br.com.montreal.blog.repository.TemaRepository;
import br.com.montreal.blog.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class PostagemService {

    private PostagemRepository postagemRepository;

    private TemaRepository temaRepository;

    private UsuarioRepository usuarioRepository;

    public PostagemService(PostagemRepository postagemRepository,
                           TemaRepository temaRepository,
                           UsuarioRepository usuarioRepository) {
        this.postagemRepository = postagemRepository;
        this.temaRepository = temaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Postagem save(PostagemDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Tema tema = temaRepository.findById(dto.temaId())
                .orElseThrow(() -> new RuntimeException("Tema não encontrado"));

        Postagem postagem = new Postagem();
        postagem.setTitulo(dto.titulo());
        postagem.setTexto(dto.texto());
        postagem.setUsuario(usuario);
        postagem.setTema(tema);

        return postagemRepository.save(postagem);
    }

    public Postagem update(Long id, PostagemDTO dto) {
        Postagem postagem = postagemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Postagem não encontrada"));

        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Tema tema = temaRepository.findById(dto.temaId())
                .orElseThrow(() -> new RuntimeException("Tema não encontrado"));

        postagem.setTitulo(dto.titulo());
        postagem.setTexto(dto.texto());
        postagem.setUsuario(usuario);
        postagem.setTema(tema);

        return postagemRepository.save(postagem);
    }

}

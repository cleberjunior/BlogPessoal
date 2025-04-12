package br.com.montreal.blog.post;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PostagemController implements PostagemApi {

    @NonNull
    private final PostagemService service;

    @Override
    public ResponseEntity<PostagemDTO> criar(PostagemDTO postagemDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(postagemDTO));
    }

    @Override
    public ResponseEntity<PostagemDTO> atualizar(Long id, PostagemDTO postagemDTO) {
        return ResponseEntity.ok(service.atualizar(id, postagemDTO));
    }

    @Override
    public ResponseEntity<Void> excluir(Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<PostagemDTO>> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @Override
    public ResponseEntity<PostagemDTO> buscarPorId(Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }
}

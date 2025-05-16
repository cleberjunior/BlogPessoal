package br.com.montreal.blog.tema;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequiredArgsConstructor
public class TemaController implements TemaApi {

    private final TemaService service;

    @Override
    public ResponseEntity<TemaDTO> criar(@RequestBody @Valid TemaDTO temaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(temaDTO));
    }

    @Override
    public ResponseEntity<TemaDTO> atualizar(@PathVariable Long id, @RequestBody @Valid TemaDTO temaDTO) {
        return ResponseEntity.ok(service.atualizar(id, temaDTO));
    }

    @Override
    public ResponseEntity excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<TemaDTO>> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @Override
    public ResponseEntity<TemaDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarById(id));
    }
}

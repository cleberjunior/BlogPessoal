package br.com.montreal.blog.tema;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/temas")
@SecurityRequirement(name = "bearer-key")
@Validated
public interface TemaApi {
    @PostMapping
    ResponseEntity<TemaDTO> criar(@RequestBody @Valid TemaDTO temaDTO);

    @PutMapping("/{id}")
    ResponseEntity<TemaDTO> atualizar(@PathVariable Long id, @RequestBody @Valid TemaDTO temaDTO);

    @DeleteMapping("/{id}")
    ResponseEntity excluir(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<TemaDTO>> listarTodos();

    @GetMapping("/{id}")
    ResponseEntity<TemaDTO> buscarPorId(@PathVariable Long id);
}

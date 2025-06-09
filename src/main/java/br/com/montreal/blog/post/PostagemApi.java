package br.com.montreal.blog.post;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@SecurityRequirement(name = "bearer-key")
@RequestMapping("/api/postagens")
@Validated
public interface PostagemApi {

    @PostMapping
    ResponseEntity<PostagemDTO> criar(@RequestBody @Valid PostagemDTO postagemDTO);

    @PutMapping("/{id}")
    ResponseEntity<PostagemDTO> atualizar(@PathVariable Long id, @RequestBody @Valid PostagemDTO postagemDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> excluir(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<PostagemDTO>> listarTodos();

    @GetMapping("/{id}")
    ResponseEntity<PostagemDTO> buscarPorId(@PathVariable Long id);
}

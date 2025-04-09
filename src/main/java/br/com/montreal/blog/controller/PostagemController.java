package br.com.montreal.blog.controller;

import br.com.montreal.blog.dto.PostagemDTO;
import br.com.montreal.blog.model.Postagem;
import br.com.montreal.blog.model.Postagem;
import br.com.montreal.blog.service.PostagemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/postagens")
public class PostagemController {

    private PostagemService service;

    public PostagemController(PostagemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Postagem> inserir(@RequestBody @Valid PostagemDTO postagemDTO) {
        Postagem postagem = service.save(postagemDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(postagem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Postagem> atualizar(@PathVariable Long id,
                                                      @RequestBody @Valid PostagemDTO postagemDTO) {
        Postagem postagem = service.update(id, postagemDTO);
        return ResponseEntity.ok(postagem);
    }

    @GetMapping
    public ResponseEntity<List<Postagem>> listarTodos(){
        return ResponseEntity.ok(service.listarAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postagem> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}

package br.com.montreal.blog.controller;

import br.com.montreal.blog.dto.TemaDTO;
import br.com.montreal.blog.model.Tema;
import br.com.montreal.blog.service.TemaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/temas")
public class TemaController {
    
    private TemaService service;

    public TemaController(TemaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Tema> inserir(@RequestBody TemaDTO temaDTO) {
        Tema tema = service.save(temaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(tema);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tema> atualizar(@PathVariable Long id, @RequestBody TemaDTO temaDTO) {
        Tema tema = service.update(id, temaDTO);
        return ResponseEntity.ok(tema);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        if (service.delete(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Tema>> listarTodos(){
        return ResponseEntity.ok(service.listarAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tema> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}

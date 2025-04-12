package br.com.montreal.blog.post;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/temas")
@SecurityRequirement(name = "bearer-key")
public class TemaController {

    private TemaService service;

    public TemaController(TemaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Tema> inserir(@RequestBody @Valid TemaDTO temaDTO) {
        Tema tema = service.save(temaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(tema);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tema> atualizar(@PathVariable Long id, @RequestBody @Valid TemaDTO temaDTO) {
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

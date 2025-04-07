package br.com.montreal.blog.service;

import br.com.montreal.blog.dto.TemaDTO;
import br.com.montreal.blog.model.Tema;
import br.com.montreal.blog.repository.TemaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemaService {
    
    private TemaRepository repository;

    public TemaService(TemaRepository repository) {
        this.repository = repository;
    }

    public Tema save(TemaDTO temaDTO) {
        Tema tema = new Tema();
        tema.setDescricao(temaDTO.descricao());

        return repository.save(tema);
    }

    public Tema update(Long id, TemaDTO temaDTO) {
        Tema tema = repository.findById(id).get();
        tema.setDescricao(temaDTO.descricao());

        return repository.save(tema);
    }

    public boolean delete(Long id) {
        Tema tema = repository.findById(id).get();
        if (tema != null) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Tema> listarAll(){
        List<Tema> temas = repository.findAll();
        return temas;
    }

    public Tema findById(Long id) {
        return repository.findById(id).get();
    }
}

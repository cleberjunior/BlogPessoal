package br.com.montreal.blog.repository;

import br.com.montreal.blog.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository extends JpaRepository<Tema, Long> {
}

package br.com.montreal.blog.repository;

import br.com.montreal.blog.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
}

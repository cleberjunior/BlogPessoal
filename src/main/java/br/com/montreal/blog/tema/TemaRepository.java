package br.com.montreal.blog.tema;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemaRepository extends JpaRepository<TemaEntity, Long> {
}

package br.com.montreal.blog.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<PostagemEntity, Long> {

    //Integer obterTotalPostagemPorUsuario(Long id);
}

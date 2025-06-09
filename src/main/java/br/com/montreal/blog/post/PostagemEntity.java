package br.com.montreal.blog.post;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.montreal.blog.tema.TemaEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import br.com.montreal.blog.user.UsuarioEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "postagens")
public class PostagemEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "postagem_sequence")
    @SequenceGenerator(name = "postagem_sequence", sequenceName = "postagem_sequence", allocationSize = 1)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, length = 255)
    private String titulo;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String conteudo;

    @Column(nullable = false, length = 255)
    private String autor;

    @CreationTimestamp
    @Column(insertable = true, updatable = false, nullable = false)
    private LocalDateTime criadoEm;

    @UpdateTimestamp
    @Column(updatable = true, nullable = false)
    private LocalDateTime atualizadoEm;

    @ManyToOne
    @JoinColumn(name = "tema_id")
    @JsonIgnore // Evita loop ao serializar
    private TemaEntity tema;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore // Evita loop ao serializar
    private UsuarioEntity usuario;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.criadoEm = now;
        this.atualizadoEm = now;
    }

    @PreUpdate
    protected void onUpdate() {
        this.atualizadoEm = LocalDateTime.now();
    }

    public PostagemEntity(String titulo, String conteudo, String autor, Long temaId,
            Long usuarioId) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.autor = autor;
        this.tema = new TemaEntity(temaId);
        this.usuario = new UsuarioEntity(usuarioId);
    }
}

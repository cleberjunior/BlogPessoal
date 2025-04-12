package br.com.montreal.blog.post;

import java.io.Serializable;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import br.com.montreal.blog.user.Usuario;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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
    private String texto;

    @CreationTimestamp
    @Column(insertable = true, updatable = false, nullable = false)
    private LocalDateTime criadoEm;

    @UpdateTimestamp
    @Column(insertable = false, updatable = true, nullable = false)
    private LocalDateTime atualizadoEm;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "tema_id")
    private Tema tema;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public PostagemEntity(String titulo, String texto, Long temaId,
            Long usuarioId) {
        this.titulo = titulo;
        this.texto = texto;
        this.tema = new Tema(temaId);
        this.usuario = new Usuario(usuarioId);
    }

}

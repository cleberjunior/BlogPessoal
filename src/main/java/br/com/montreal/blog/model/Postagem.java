package br.com.montreal.blog.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "postagens")
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String texto;

    private LocalDateTime data;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "tema_id")
    private Tema tema;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}

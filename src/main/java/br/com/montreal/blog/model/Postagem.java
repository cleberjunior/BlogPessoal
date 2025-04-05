package br.com.montreal.blog.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "postagens")
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String texto;

    private LocalDateTime data;

    private Tema tema;

    private Usuario usuario;
}

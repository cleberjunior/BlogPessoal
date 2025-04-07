package br.com.montreal.blog.dto;

import java.time.LocalDateTime;

public record PostagemDTO(String titulo,
                         String texto,
                         Long temaId,
                         Long usuarioId) {
}

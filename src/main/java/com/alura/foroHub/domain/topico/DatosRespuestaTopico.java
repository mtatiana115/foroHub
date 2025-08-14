package com.alura.foroHub.domain.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String autor,
        Curso curso
) {
    public DatosRespuestaTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(),
             topico.getFechaCreacion(), topico.getAutor().getLogin(), topico.getCurso());
    }
}
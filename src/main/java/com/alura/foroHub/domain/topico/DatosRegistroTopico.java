package com.alura.foroHub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
    @NotBlank
    String titulo,
    @NotBlank
    String mensaje,
    @NotNull
    Long autorId,
    @NotNull
    Curso curso
) {}
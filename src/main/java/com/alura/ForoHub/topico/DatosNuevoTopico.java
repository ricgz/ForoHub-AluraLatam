package com.alura.ForoHub.topico;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosNuevoTopico(
        @NotNull
        Long usuario_id,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Cursos curso
) {
}

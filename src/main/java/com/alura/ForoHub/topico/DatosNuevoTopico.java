package com.alura.ForoHub.topico;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/***
 * DTO para la creacion de un nuevo topico en BD
 * @param usuario_id
 * @param titulo
 * @param mensaje
 * @param curso
 */
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

package com.alura.ForoHub.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/***
 * DTO para los datos recibidos que seran actualizados del Topico especificado
 * @param id
 * @param titulo
 * @param mensaje
 * @param estado
 * @param curso
 */
public record DatosActualizarTopico(
        @NotNull
        Long id,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        Boolean estado,
        @NotBlank
        Cursos curso
) {
}

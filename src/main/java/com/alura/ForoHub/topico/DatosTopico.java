package com.alura.ForoHub.topico;

import java.time.LocalDateTime;

/***
 * DTO para mostrar al usuario los datos de un topico
 * @param id
 * @param usuario_id
 * @param titulo
 * @param mensaje
 * @param curso
 * @param estado
 * @param creado
 */
public record DatosTopico(
    Long id,
    Long usuario_id,
    String titulo,
    String mensaje,
    Cursos curso,
    Boolean estado,
    LocalDateTime creado
    ){

    public DatosTopico(Topico topico){
        this(topico.getId(), topico.getUsuario_id(), topico.getTitulo(),
                topico.getMensaje(), topico.getCurso(), topico.getEstado(),
                topico.getCreado());
    }

}

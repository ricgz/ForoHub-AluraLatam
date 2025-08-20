package com.alura.ForoHub.topico;

import com.alura.ForoHub.usuario.Datoslogin;

import java.time.LocalDateTime;

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

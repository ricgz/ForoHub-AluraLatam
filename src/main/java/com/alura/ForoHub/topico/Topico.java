package com.alura.ForoHub.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Long usuario_id;
        @Column(unique = true)
        private String titulo;
        @Column(unique = true)
        private String mensaje;
        @Enumerated(EnumType.STRING)
        private Cursos curso;
        private Boolean estado;
        private LocalDateTime creado;

        public Topico(DatosNuevoTopico datos) {
                this.usuario_id = datos.usuario_id();
                this.titulo = datos.titulo();
                this.mensaje = datos.mensaje();
                this.curso = datos.curso();
                this.estado = true;
                this.creado = LocalDateTime.now();
        }

        public void actualizar(DatosActualizarTopico datos) {
                if(datos.titulo() != null) this.titulo = datos.titulo();
                if(datos.mensaje() != null) this.mensaje = datos.mensaje();
                if(datos.estado() != null) this.estado = datos.estado();
                if(datos.curso() != null) this.curso = datos.curso();
        }
}

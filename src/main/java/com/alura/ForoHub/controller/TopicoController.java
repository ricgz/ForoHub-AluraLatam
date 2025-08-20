package com.alura.ForoHub.controller;

import com.alura.ForoHub.topico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    /**
     * Lista todos los topicos en la BD
     * @param paginacion
     * @return
     */
    @GetMapping
    public ResponseEntity<Page<DatosTopico>> listar(@PageableDefault(size = 10) Pageable paginacion) {
        return ResponseEntity
                .ok(repository
                        .findByTop10ByFecha(paginacion)
                        .map(DatosTopico::new));
    }

    /***
     * Registra unnuevo topico en la BD, solo si esta no existe (titulo unico)
     * @param datos
     * @param uriComponentsBuilder
     * @return
     */
    @Transactional
    @PostMapping
    public ResponseEntity nuevo(@RequestBody @Valid DatosNuevoTopico datos, UriComponentsBuilder uriComponentsBuilder){
        var topico = new Topico(datos);

        repository.save(topico);
        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity
                .created(uri)
                .body(new DatosTopico(topico));
    }

    /***
     * Muestra un topico en especifico
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity ver(@PathVariable Long id){
        var resultado = repository.getTopicoById(id);

        if(resultado.isPresent()){
            var topico = resultado.get();
            var datosTopico = new DatosTopico(topico);
            return ResponseEntity
                    .ok(datosTopico);
        }else{
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }

    /***
     * Actualiza los datos de un topico
     * @param id
     * @param datos
     * @return
     */
    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity actualizar(@PathVariable Long id, @RequestBody DatosActualizarTopico datos){
        var resultado = repository.getTopicoById(id);

        if(resultado.isPresent()){
            var topico = resultado.get();
            topico.actualizar(datos);
            return ResponseEntity
                    .ok(new DatosTopico(topico));
        }else{
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }

    /***
     * Elimina un topico de la BD por su ID
     * @param id
     * @return
     */
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        var resultado = repository.getTopicoById(id);

        if(resultado.isPresent()){
            repository.deleteById(id);
            return ResponseEntity
                    .ok().build();
        }else{
            return ResponseEntity
                    .notFound().build();
        }
    }
}

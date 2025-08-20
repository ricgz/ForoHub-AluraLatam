package com.alura.ForoHub.controller;

import com.alura.ForoHub.topico.*;
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
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @GetMapping
    public ResponseEntity<Page<DatosTopico>> listar(@PageableDefault(size = 10) Pageable paginacion) {
        return ResponseEntity.ok(repository.findByTop10ByFecha_creacion(paginacion).map(DatosTopico::new));
    }


    @Transactional
    @PostMapping
    public ResponseEntity nuevo(@RequestBody @Valid DatosNuevoTopico datos, UriComponentsBuilder uriComponentsBuilder){
        // agregar un nuevo topico en la base de datos
        var topico = new Topico(datos);
        repository.save(topico);
        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DatosTopico(topico));
    }

    @GetMapping("/{id}")
    public ResponseEntity ver(@PathVariable Long id){
        var resultado = repository.getTopicoById(id);

        if(resultado.isPresent()){
            var topico = resultado.get();
            var datosTopico = new DatosTopico(topico);
            return ResponseEntity.ok(datosTopico);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity actualizar(@PathVariable Long id, @RequestBody DatosActualizarTopico datos){
        var resultado = repository.getTopicoById(id);

        if(resultado.isPresent()){
            var topico = resultado.get();
            topico.actualizarInformacion(datos);
            return ResponseEntity.ok(new DatosTopico(topico));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        var resultado = repository.getTopicoById(id);

        if(resultado.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}

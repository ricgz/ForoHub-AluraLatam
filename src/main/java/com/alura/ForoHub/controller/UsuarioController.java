package com.alura.ForoHub.controller;

import com.alura.ForoHub.usuario.Datoslogin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @GetMapping
    public ResponseEntity validar(@RequestBody Datoslogin datos){

        return ResponseEntity.ok(datos);
    }


}

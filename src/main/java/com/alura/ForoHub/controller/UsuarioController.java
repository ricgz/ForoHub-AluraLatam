package com.alura.ForoHub.controller;

import com.alura.ForoHub.infra.security.DatosTokenJWT;
import com.alura.ForoHub.infra.security.TokenService;
import com.alura.ForoHub.usuario.Datoslogin;
import com.alura.ForoHub.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class UsuarioController {

    // inyectamos las dependencias necesarias...
    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;


    @PostMapping
    public ResponseEntity login(@RequestBody @Valid Datoslogin datos){
        //System.out.println(datos);    // debug de datos de usuario...
        try{
            var authenticationToken = new UsernamePasswordAuthenticationToken(datos.email(), datos.password());
            var autentication = manager.authenticate(authenticationToken);
            var tokenJWT = tokenService.generarToken((Usuario) autentication.getPrincipal());


            return ResponseEntity
                    .ok(new DatosTokenJWT(tokenJWT));
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }
}

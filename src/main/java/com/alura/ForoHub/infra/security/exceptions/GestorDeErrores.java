package com.alura.ForoHub.infra.security.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GestorDeErrores {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity gestorError404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity gestorError400(MethodArgumentNotValidException ex){

        var errores = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(errores.stream().map(DatosCamposErroneos::new).toList());
    }

    public record DatosCamposErroneos(
            String campo,
            String mensaje
    ){
        public DatosCamposErroneos(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }


}

package com.alura.ForoHub.usuario;

/***
 * DTO para datos de identificacion y login
 * @param email
 * @param password
 */
public record Datoslogin(
        String email,
        String password
) {
}

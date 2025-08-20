package com.alura.ForoHub.infra.security;

/***
 * DTO para envio de Token al loguear con exito
 * @param token
 */
public record DatosTokenJWT(String token) {
}

package com.alura.ForoHub.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT"))
                )
                .info(new Info()
                        .title("Foro Hub v1")
                        .description("API Rest de un Foro desarrollado en Alura.<br>" +
                                "Si quieres probar el sistema haz un login en el endpoint <b>/login</b> y el usuario <b>demo@forohub.com</b> y contraseña <b>demo</b>")
                        .contact(new Contact()
                                .name("Equipo Backend Foro hub")
                                .email("webmaster@forohub.com"))
                        );
    }
}

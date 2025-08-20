# Challenge ForoHub Alura

## :eyes: Descripción
ForoHub Alura es una aplicación desarrollada en Java con Spring Boot 3, que permite levantar un servidor y exponer una API REST con funcionalidades básicas para la gestión de un foro.

Aunque se trata de una aplicación sencilla, incorpora diversas características útiles, tanto en materia de seguridad como en la aplicación de buenas prácticas de desarrollo. Por esta razón, puede servir como una guía base para implementar sistemas más completos y robustos. Además, su desarrollo continuará evolucionando con el tiempo, incorporando nuevas mejoras.

Cabe destacar que esta API no incluye una interfaz gráfica, ya que está orientada al desarrollo backend, pero puede integrarse sin dificultad con cualquier solución frontend.

## :gear: Requisitos de entorno
- Java 17.
- MySQL como motor de Base de datos.
- Configura tus parametros de Base de Datos en el archivo </b>application.properties</b>.
- Usuario y contraseña por defecto al ejecutar el login: demo@forohub.com/demo.

 
## 🏹 Endpoint habilitados
[GET] /topicos/{id} ▶️ Ver un topico existente.<br>
[PUT] /topicos/{id} ▶️ Actualizar un topico existente.<br>
[DELETE] /topicos/{id} ▶️ Eliminar un topico existente.<br>
[GET] /topicos▶️ Lista todos los topicos existentes.<br>
[POST] /topicos ▶️ Registra un nuevo topico en el sistema.<br><br>
[POST] /login ▶️ Permite reazlizar un login para poder utilzar los metodos anterior.


# [GET] Ver un topico exstente.
- /topicos/{id} 

## documentacion de Endopoint mediante Swagger-UI (Open-API)
Una vez ejecutada la aplicacion, pueedes acceder a [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html), para revisar la documentacion autogenerada.

<img width="1678" height="889" alt="Documentacion Swagger-UI" src="https://github.com/user-attachments/assets/8f574c07-7822-4fea-a930-b8baffde3144" />


## Espero que te sea util y un aporte!!!!


Buen desarrollo 😃!!!

Zudum.dev 🚀
Zudum (un nombre inspirado en el icónico sonido Tudum de Netflix) es un proyecto de aplicación web diseñado para crear, administrar y compartir tu lista personal de series favoritas.

Este proyecto nace como parte de la evaluación de la asignatura "Desarrollo de Software Web 2" del Instituto Profesional San Sebastián, implementando un flujo CRUD simulado sobre una arquitectura Spring Boot.

🎨 La Identidad de Zudum: Colores y Diseño
Zudum se desmarca visualmente de la paleta tradicional de las plataformas de streaming. Mientras Netflix se destaca por su icónico rojo, Zudum adopta un amarillo cálido para su identidad principal, creando una experiencia vibrante y acogedora.

La paleta de colores principal es:
Componente,Color,Código Hex
Navbar (Principal),Amarillo Cálido,#FFDE21
Fondo (Body),Gris Claro,#E0E0E0
Footer (Gradiente 1),Naranja Brillante,#FFECD2
Footer (Gradiente 2),Durazno Suave,#FCB69F

El fondo gris (#E0E0E0) fue elegido estratégicamente, ya que en futuras versiones ayudará a destacar los posters de las series, los cuales serán reinventados utilizando IA.

El footer gradiente (#FFECD2 a #FCB69F) nos recuerda a un glamuroso atardecer, dándole un toque de elegancia y calidez a la aplicación.


🛠️ Stack Tecnológico (Fase 1)
Este proyecto está construido utilizando las siguientes tecnologías:

Backend: Spring Boot 3

Spring Web

Spring Boot DevTools

Frontend: Thymeleaf (Motor de plantillas del lado del servidor)

Lenguaje: Java 17

Build Tool: Apache Maven

Estilos: HTML5 y CSS3 (con variables CSS y gradientes).

🚀 Estado Actual y Futuro
Estado Actual (Fase 1 Completada)
Estructura completa del proyecto Spring Boot.

Definición de AppController con endpoints simulados (@GetMapping, @PostMapping) para todo el flujo CRUD.

Creación de 5 vistas con Thymeleaf: login, registro, index (Dashboard), form-crear y form-editar.

Implementación de fragmentos de Thymeleaf (navbar, footer) para reutilizar código.

Validaciones del lado del cliente con HTML5 (required, minlength, type="email") y JavaScript (onclick confirm).

Próximos Pasos (Fase 2)
Integración con una base de datos (H2 o MySQL).

Implementación de la capa de persistencia (JPA, Repositories) y lógica de negocio (Services).

Implementación de Spring Security para un registro y login de usuarios real.

¡Zudum estará deployeado en un servicio de hosting!

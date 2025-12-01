# Zudum – Evaluación Unidad 2 Desarrollo Web II  
Instituto Profesional San Sebastián  
Estudiante: Iván Campos Farfán  
Carrera: Técnico en Programación y Análisis de Sistemas  
Asignatura: Desarrollo Web II  
Docente: Vicente Zapata Concha

---

## Descripción del proyecto
Zudum es una aplicación web desarrollada con Spring Boot que permite a un usuario gestionar sus series en seguimiento. El sistema permite seleccionar una serie, una temporada, un episodio y un estado de visualización, registrarlo en una base de datos y visualizar el progreso en una sección de perfil.

El enfoque central del proyecto fue demostrar el uso de:
- MVC en Spring Boot
- Manejo de controladores, servicios y repositorios
- Modelos con relaciones entre entidades
- Uso de Thymeleaf para renderizado dinámico
- Consumo de datos con `fetch()` para desplegar selects dependientes

---

## Características principales
- Registro y autenticación de usuario
- Catálogo de series con imágenes (grid 3x3)
- Registrar progreso rápido en el episodio actual
- Registro completo desde formulario independiente
- Selects dependientes en tiempo real:
  - Al seleccionar serie → cargan temporadas
  - Al seleccionar temporada → cargan episodios
- Vista de perfil que muestra:
  - Serie registrada
  - Estado
  - Temporada y episodio actual
  - Modificación del estado
  - Eliminación del progreso

---

## Tecnologías utilizadas
| Capa | Tecnologías |
|------|-------------|
| Backend | Java 17, Spring Boot, Spring Data JPA |
| Frontend | Thymeleaf, HTML5, CSS3, JavaScript |
| Base de datos | H2 Database |
| Dependencias | Maven |
| Control de versiones | Git y GitHub |

---

## Arquitectura del proyecto
El proyecto está estructurado siguiendo MVC:

src/main/java/com/zudum1/zudum1
├─ controller/ [Controladores]
├─ service/ [Interfaces + Implementaciones]
├─ repository/ [Repositorios JPA]
├─ model/ [Entidades JPA]
└─ config/ [Cargador de datos DataLoader]

## Cómo ejecutar el proyecto
1. Clonar el repositorio
git clone https://github.com/ivancf89/zudum.git


2. Cambiar a la rama del proyecto
git checkout zudum-chapter2


3. Ejecutar el servidor
.\mvnw spring-boot:run


4. Acceder en navegador
http://localhost:8080

---

## Documento de evaluación
El informe completo requerido en la evaluación se encuentra disponible en formato PDF en la raíz del repositorio:

EVAL_U2 WEB II-CAMPOS.FARFAN.IVAN.pdf

Copiar código

En el documento se detalla el análisis técnico, capturas de pantalla y conclusiones.

---

## Autor
**Iván Campos Farfán**  
Estudiante de Técnico en Programación y Análisis de Sistemas  
Instituto Profesional San Sebastián

---

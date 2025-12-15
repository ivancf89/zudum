# ZUDUM – Chapter 3  
**Docker, Profiles, TiDB Cloud & Railway Deployment**

## 📌 Descripción general

ZUDUM es un proyecto académico desarrollado con **Spring Boot + Thymeleaf**, orientado a la gestión de series, temporadas y episodios, permitiendo a los usuarios registrar su progreso de visualización.

En este **Chapter 3**, el proyecto evoluciona desde un entorno local hacia un **despliegue productivo real**, incorporando:

- Contenerización con Docker
- Separación de perfiles de configuración (local / producción)
- Base de datos en la nube con **TiDB Cloud**
- Despliegue continuo en **Railway**

---

## 🧱 Arquitectura utilizada

- **Backend:** Spring Boot 3.5.7
- **Frontend:** Thymeleaf
- **ORM:** Spring Data JPA / Hibernate
- **Seguridad:** Spring Security
- **Contenedores:** Docker (multi-stage build)
- **Base de datos local:** H2
- **Base de datos producción:** TiDB Cloud (compatible MySQL)
- **Plataforma de despliegue:** Railway

---

## 🌿 Perfiles de configuración

El proyecto utiliza perfiles de Spring para separar entornos:

### 🔹 Perfil `local`
Archivo: `application-local.properties`

- Base de datos H2 en memoria
- Consola H2 habilitada
- Uso en desarrollo local

### 🔹 Perfil `prod`
Archivo: `application-prod.properties`

- Conexión a TiDB Cloud
- Credenciales inyectadas por variables de entorno
- Pool de conexiones optimizado (HikariCP)
- Uso en Docker / Railway

Activación del perfil:
```bash
SPRING_PROFILES_ACTIVE=prod
Docker

El proyecto se encuentra completamente dockerizado mediante un Dockerfile multi-stage, que:

Compila el proyecto con Maven

Genera el JAR final

Ejecuta la aplicación sobre una imagen JRE liviana

Construcción de imagen
docker build -t zudum:local .

Ejecución con TiDB (producción)
docker run -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=prod \
  -e DB_URL="jdbc:mysql://gateway01.us-east-1.prod.aws.tidbcloud.com:4000/test?useSSL=true&requireSSL=true&verifyServerCertificate=true" \
  -e DB_USERNAME="USUARIO_TIDB" \
  -e DB_PASSWORD="PASSWORD_TIDB" \
  zudum:local

 TiDB Cloud

Cluster Starter en TiDB Cloud

Conexión segura mediante TLS

Compatible con MySQL

Usado como base de datos productiva real

La aplicación fue probada exitosamente realizando:

Login

Carga de catálogo

Registro y actualización de progreso

Eliminación de series

Persistencia entre sesiones

 Railway

El proyecto fue desplegado exitosamente en Railway utilizando:

Imagen Docker publicada en Docker Hub

Variables de entorno configuradas desde Railway

Perfil prod activo

URL de producción:
https://zudum-production.up.railway.app/

Todas las funcionalidades fueron validadas directamente en producción.

Control de versiones

Rama principal de este avance:
zudum-chapter3

Incluye:

Dockerfile

Separación de controladores

Configuración de seguridad

Perfiles de entorno

Despliegue productivo
 Estado del proyecto

✔ Contenedor local funcionando
✔ Conexión exitosa a TiDB Cloud
✔ Despliegue productivo estable
✔ Persistencia real de datos
✔ Flujo completo de usuario validado

Autor

Iván Campos Farfán
Técnico en Programación y Análisis de Sistemas
Proyecto académico – Desarrollo de Software Web

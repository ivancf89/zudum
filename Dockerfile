# ---------- Build stage ----------
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

# Copiamos lo mínimo primero para aprovechar cache
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Descarga dependencias (cache)
RUN ./mvnw -q -DskipTests dependency:go-offline

# Ahora copiamos el código
COPY src src

# Compila
RUN ./mvnw -DskipTests clean package

# ---------- Run stage ----------
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copiamos el jar final
COPY --from=build /app/target/*.jar app.jar

# Railway suele inyectar PORT. Spring Boot puede leerlo.
ENV PORT=8080
EXPOSE 8080

# Importante: usar $PORT
ENTRYPOINT ["sh","-c","java -Dserver.port=${PORT} -jar app.jar"]

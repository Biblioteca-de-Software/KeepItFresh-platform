# Etapa 1: Build con Maven y Java 21
FROM eclipse-temurin:21 AS build

WORKDIR /app

# Copiamos solo archivos necesarios primero para aprovechar el cache
COPY pom.xml .
COPY .mvn/ .mvn
COPY mvnw .
RUN ./mvnw dependency:go-offline -B

# Copiamos el resto del código y construimos el JAR
COPY src ./src
RUN ./mvnw package -DskipTests -B

# Etapa 2: Imagen mínima para ejecutar el JAR
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copiamos el JAR desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Puerto expuesto para Render
EXPOSE 8080

# Comando de inicio
ENTRYPOINT ["java", "-jar", "app.jar"]

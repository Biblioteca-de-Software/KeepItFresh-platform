# Etapa 1: Build del JAR
FROM eclipse-temurin:21 AS build

WORKDIR /app

# Copiamos Maven Wrapper y configuración
COPY mvnw .
COPY .mvn/ .mvn
RUN chmod +x mvnw

# Copiamos POM y descargamos dependencias primero (cache eficiente)
COPY pom.xml .
RUN ./mvnw dependency:go-offline -B

# Copiamos el resto del código fuente
COPY src ./src

# Compilamos con soporte para preview features (configurado en pom.xml)
RUN ./mvnw package -DskipTests -B

# Etapa 2: Imagen final liviana para ejecutar
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copiamos el JAR desde el build stage
COPY --from=build /app/target/*.jar app.jar

# Activamos el perfil prod para Spring Boot
ENV SPRING_PROFILES_ACTIVE=prod

# Ejecutamos la app con preview features activadas
ENTRYPOINT ["java", "--enable-preview", "-jar", "app.jar"]

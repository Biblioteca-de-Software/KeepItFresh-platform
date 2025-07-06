# Etapa 1: Construcción del JAR
FROM eclipse-temurin:21 AS build

WORKDIR /app

# Copiamos Maven Wrapper y damos permisos
COPY mvnw .
COPY .mvn/ .mvn
RUN chmod +x mvnw

# Copiamos POM y descargamos dependencias
COPY pom.xml .
RUN ./mvnw dependency:go-offline -B

# Copiamos el resto del código fuente
COPY src ./src

# Compilamos con soporte para preview features
RUN ./mvnw package -DskipTests -B

# Etapa 2: Imagen de ejecución más liviana
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copiamos el JAR desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Comando para ejecutar la app con preview features habilitadas
ENTRYPOINT ["java", "--enable-preview", "-jar", "app.jar"]

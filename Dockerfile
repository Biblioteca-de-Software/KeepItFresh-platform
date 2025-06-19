# Etapa de compilación con Java 24 y Maven
FROM eclipse-temurin:24-jdk as build

WORKDIR /app

COPY . .

RUN chmod +x ./mvnw && ./mvnw clean install -DskipTests

# Etapa final para ejecutar la aplicación
FROM eclipse-temurin:24-jdk

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]

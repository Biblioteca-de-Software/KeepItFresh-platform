# Build stage
FROM maven:3.9.9-eclipse-temurin-24 AS build

WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

# Habilita modo debug y limpia antes de compilar
RUN mvn clean package -DskipTests -X --no-transfer-progress

# Runtime stage
FROM eclipse-temurin:24-jre AS runtime

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

ENV SPRING_PROFILES_ACTIVE=prod
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

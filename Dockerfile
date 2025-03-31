# Build stage
FROM openjdk:17-jdk-slim AS build
WORKDIR /app
COPY . .
RUN chmod +x mvnw  # Maven Wrapper ko executable bana
RUN ./mvnw clean package -DskipTests

# Run stage
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]
EXPOSE 8080
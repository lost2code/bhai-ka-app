# Base image: OpenJDK 17
FROM openjdk:17-jdk-slim

# Working directory set kar
WORKDIR /app

# Maven build files copy kar
COPY pom.xml .
COPY src ./src

# Dependencies aur project build kar
RUN apt-get update && apt-get install -y maven
RUN mvn clean package -DskipTests

# JAR file ko run karne ke liye command
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]

# Port expose kar (Spring Boot default port)
EXPOSE 8080
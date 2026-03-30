
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template


FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package



FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/customer-management-1.0.0.jar /app/app.jar
CMD ["java", "-jar", "app.jar"]

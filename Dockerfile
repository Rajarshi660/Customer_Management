
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY target/customer-management-1.0.0.jar /app/app.jar
CMD ["java","-jar","app.jar"]

FROM eclipse-temurin:20-jre-jammy

COPY target/*.jar /app/app.jar
WORKDIR /app
EXPOSE 8004
ENTRYPOINT ["java","-jar","/app/app.jar"]

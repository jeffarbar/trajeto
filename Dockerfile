FROM openjdk:8-jdk-alpine
RUN mkdir /app
COPY target/*.jar /app/trajeto.jar
WORKDIR /app
EXPOSE 8092
ENTRYPOINT ["java", "-jar", "trajeto.jar"]
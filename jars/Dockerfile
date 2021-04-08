
FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE="/*.jar"
ARG datasource=localhost
ENV datasource=${datasource}
ARG message=itdidntworkeddockerCompose
ENV message=${message}
COPY ${JAR_FILE} client-0.0.1-SNAPSHOT.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar", "client-0.0.1-SNAPSHOT.jar", "--log.initial.message=${message}", "--spring.datasource.url=jdbc:mysql://${datasource}:3306/db"]

FROM openjdk:18
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/licensing-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
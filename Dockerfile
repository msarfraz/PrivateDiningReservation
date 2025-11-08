FROM eclipse-temurin
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} webservice.jar
# following copy not required, data.sql is executed by spring boot automatically from /resources
COPY /src/main/resources/data.sql init_db.sql
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/webservice.jar"]

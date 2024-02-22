FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY tasks/*.jar app.jar

EXPOSE 8080
RUN cat  /usr/src/app/src/main/resources/application-render.properties >  /usr/src/app/src/main/resources/application.properties
RUN chmod +x gradlew
RUN echo ${MYSQL_DB_URL}
RUN ./gradlew build -PMYSQL_DB_URL="jdbc:${MYSQL_DB_URL}"

ENTRYPOINT ["java","-jar","/usr/src/app/build/libs/tasks-0.0.1-SNAPSHOT.jar"]
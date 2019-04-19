FROM maven:3.5.2-jdk-9 AS build  
COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app  
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:9  
COPY --from=build /usr/src/app/target/examen-0.0.1-SNAPSHOT.jar /usr/app/examen-0.0.1-SNAPSHOT.jar  
EXPOSE 8080  
ENTRYPOINT ["java","-jar","/usr/app/examen-0.0.1-SNAPSHOT.jar"]  
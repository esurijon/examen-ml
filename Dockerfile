FROM openjdk:8  
COPY ml-solarsystem-0.0.1-SNAPSHOT.jar /usr/app/ml-solarsystem-0.0.1-SNAPSHOT.jar
EXPOSE 8080  
ENTRYPOINT ["java","-jar","/usr/app/ml-solarsystem-0.0.1-SNAPSHOT.jar"]  
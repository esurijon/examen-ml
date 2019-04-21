# Ejecucion via consola
mvn exec:java

# build docker image
docker build -t esurijon/ml-solarsystem:latest .

# publish docker image
docker login
docker push esurijon/ml-solarsystem:latest

# deploy docker container
docker run --publish=8080:8080 esurijon/ml-solarsystem:latest

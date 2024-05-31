FROM anapsix/alpine-java

WORKDIR /app

MAINTAINER myNAME

COPY /build/libs/hackaton-it-one-backend-0.0.1-SNAPSHOT.jar /app/hackaton-it-one-backend-0.0.1-SNAPSHOT.jar

CMD ["java","-jar","/app/hackaton-it-one-backend-0.0.1-SNAPSHOT.jar"]
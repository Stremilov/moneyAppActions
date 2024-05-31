FROM anapsix/alpine-java

WORKDIR /app

MAINTAINER myNAME

CMD ["./gradlew", "build"]

COPY /build/libs/hackaton-it-one-backend-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]
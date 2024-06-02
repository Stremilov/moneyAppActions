#FROM gradle:7.3.3-jdk11 AS build
#
#WORKDIR /app
#
#COPY . .
#
#RUN ["chmod", "+x", 'gradlew']
#
#RUN ["./gradlew", "build"]
#
#FROM openjdk:11-jre-slim
#
#WORKDIR /app
#
#COPY --from=build /app/build/libs/hackaton-it-one-backend-0.0.1-SNAPSHOT.jar /app/app.jar
#
#CMD ["java", "-jar", "/app/app.jar"]

#FROM gradle:4.7.0-jdk8-alpine AS build
#COPY --chown=gradle:gradle . /home/gradle/src
#WORKDIR /home/gradle/src
#RUN gradle build --no-daemon
#
#FROM openjdk:8-jre-slim
#
#EXPOSE 8081
#
#RUN mkdir /app
#
#COPY --from=build /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar
#
#ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]
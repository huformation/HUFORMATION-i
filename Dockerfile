FROM openjdk:8-jdk AS builder
COPY ./ /huformation-server
WORKDIR /huformation-server
RUN chmod +x ./gradlew
RUN ./gradlew bootJar

FROM openjdk:8-jdk
COPY --from=builder ./huformation-server/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
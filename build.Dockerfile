FROM --platform=amd64 gradle:jdk16 AS builder

WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . /home/gradle/src

RUN gradle build --no-daemon

FROM openjdk:16.0.2

RUN adduser --system --no-create-home spring

COPY --from=builder /home/gradle/src/app/build/libs/*SNAPSHOT.jar qrgen.jar

EXPOSE 8080

USER spring
ENTRYPOINT ["java", "-jar", "qrgen.jar"]

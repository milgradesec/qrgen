FROM --platform=amd64 gradle:jdk15 AS builder

WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . /home/gradle/src

RUN gradle build --no-daemon

FROM openjdk:15-slim

COPY --from=builder /home/gradle/src/app/build/libs/qrgen-*-SNAPSHOT qrgen.jar

EXPOSE 8080
ENTRYPOINT exec java -jar qrgen.jar

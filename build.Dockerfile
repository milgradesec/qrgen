FROM --platform=amd64 gradle:jdk15 AS builder

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

RUN gradle build --no-daemon

FROM openjdk:15-slim

ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS

VOLUME /tmp
COPY --from=builder /home/gradle/src/app/build/libs/*.jar qrgen.jar

EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar qrgen.jar

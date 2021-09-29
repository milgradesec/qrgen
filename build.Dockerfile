FROM --platform=amd64 gradle:jdk16 AS builder

WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . /home/gradle/src

RUN gradle build --no-daemon

FROM eclipse-temurin:17-jdk

RUN adduser --system --no-create-home spring

COPY --from=builder /home/gradle/src/server/build/libs/server.jar qrgen-server.jar

EXPOSE 8080

USER spring
ENTRYPOINT ["java", "-jar", "qrgen-server.jar"]

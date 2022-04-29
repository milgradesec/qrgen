FROM --platform=amd64 gradle:jdk17 AS builder

WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . /home/gradle/src

RUN gradle build --no-daemon

FROM gcr.io/distroless/java17-debian11:nonroot

COPY --from=builder /home/gradle/src/server/build/libs/server.jar qrgen-server.jar

EXPOSE 8080

USER nonroot
ENTRYPOINT ["java", "-jar", "qrgen-server.jar"]

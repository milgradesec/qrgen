FROM --platform=amd64 gradle:jdk15 AS builder

WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . /home/gradle/src

RUN gradle build --no-daemon

FROM openjdk:15-slim

RUN addgroup --system spring && adduser --system --no-create-home spring -G spring
USER spring:spring

COPY --from=builder /home/gradle/src/app/build/libs/*.jar qrgen.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "qrgen.jar"]

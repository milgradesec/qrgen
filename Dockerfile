FROM openjdk:16-slim

RUN adduser --system --no-create-home spring
USER spring

ADD build/libs/*.jar qrgen.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "qrgen.jar"]

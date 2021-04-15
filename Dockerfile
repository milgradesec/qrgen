FROM openjdk:15-slim

RUN adduser --system --no-create-home spring
USER spring

ADD build/libs/qrgen-*-SNAPSHOT.jar qrgen.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "qrgen.jar"]

FROM openjdk:16.0.2

RUN adduser --system --no-create-home spring

ADD build/libs/*SNAPSHOT.jar qrgen.jar

EXPOSE 8080

USER spring
ENTRYPOINT ["java", "-jar", "qrgen.jar"]

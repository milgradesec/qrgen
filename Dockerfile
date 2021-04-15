FROM openjdk:15-slim

ADD build/libs/qrgen-*-SNAPSHOT.jar qrgen.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "qrgen.jar"]

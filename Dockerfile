FROM openjdk:15-slim

RUN addgroup --system spring && adduser --system --no-create-home spring -G spring
USER spring:spring

ADD build/libs/qrgen-*-SNAPSHOT.jar qrgen.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "qrgen.jar"]

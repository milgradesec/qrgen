FROM eclipse-temurin:17-jdk

RUN adduser --system --no-create-home spring

ADD build/libs/server.jar qrgen-server.jar

EXPOSE 8080

USER spring
ENTRYPOINT ["java", "-jar", "qrgen-server.jar"]

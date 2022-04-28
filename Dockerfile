FROM gcr.io/distroless/java17-debian11

ADD build/libs/server.jar qrgen-server.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "qrgen-server.jar"]
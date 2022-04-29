FROM gcr.io/distroless/java17-debian11:nonroot

ADD build/libs/server.jar qrgen-server.jar

EXPOSE 8080

USER nonroot
ENTRYPOINT ["java", "-jar", "qrgen-server.jar"]
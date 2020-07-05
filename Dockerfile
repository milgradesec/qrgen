FROM openjdk:16-slim

VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS

ADD build/libs/qrgen-0.0.1-SNAPSHOT.jar qrgen.jar
EXPOSE 8080

ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar qrgen.jar

### not used. for test.

FROM openjdk:13-alpine
#RUN mkdir /app
#WORKDIR /app

ARG JAR_FILE
COPY --chown=44 ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]



## docker build --build-arg JAR_FILE=build/libs/dontcallme-0.0.1-SNAPSHOT.jar -t wbfw109/dontcallme:0.0.1-SNAPSHOT .

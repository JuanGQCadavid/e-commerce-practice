FROM gcr.io/distroless/java

COPY ./target/authentication-0.0.1-SNAPSHOT.jar /opt/app/app.jar

WORKDIR /opt/app

ENTRYPOINT ["java","-jar","app.jar"]
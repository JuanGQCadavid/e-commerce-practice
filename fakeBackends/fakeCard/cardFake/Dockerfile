FROM gcr.io/distroless/java
COPY ./target/cardFake-0.0.1-SNAPSHOT.jar /usr/app/cardFake-0.0.1-SNAPSHOT.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","/usr/app/cardFake-0.0.1-SNAPSHOT.jar"]
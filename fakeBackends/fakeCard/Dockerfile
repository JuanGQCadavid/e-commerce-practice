FROM maven:3.5-jdk-8 AS build

COPY cardFake/src /usr/src/app/src
COPY cardFake/pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean install

FROM gcr.io/distroless/java
COPY --from=build /usr/src/app/target/cardFake-0.0.1-SNAPSHOT.jar /usr/app/cardFake-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/cardFake-0.0.1-SNAPSHOT.jar"]
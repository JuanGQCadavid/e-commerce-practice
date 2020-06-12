FROM openjdk:13

COPY ./target/stock-service-0.0.1-SNAPSHOT.jar /opt/app/app.jar

WORKDIR /opt/app

ENTRYPOINT ["java","-jar","app.jar"]
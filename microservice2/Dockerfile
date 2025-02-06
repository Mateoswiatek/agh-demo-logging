FROM openjdk:21-slim-bullseye as runtime

WORKDIR /app

COPY ./target/microservice2.jar ./

ENTRYPOINT ["java", "-jar", "microservice2.jar"]

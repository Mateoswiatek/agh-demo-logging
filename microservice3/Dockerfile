FROM openjdk:21-slim-bullseye as runtime

WORKDIR /app

COPY ./target/microservice3.jar ./

ENTRYPOINT ["java", "-jar", "microservice3.jar"]

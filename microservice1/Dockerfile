FROM openjdk:21-slim-bullseye as runtime

WORKDIR /app

COPY ./target/microservice1.jar ./

ENTRYPOINT ["java", "-jar", "microservice1.jar"]

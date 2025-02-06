mvn clean install -DskipTests
docker network create agh-demo-logging

#docker compose -f compose-infrastructure-dev.yaml down
docker compose -f compose-services.yaml down

docker compose -f compose-infrastructure-dev.yaml up -d
docker compose -f compose-services.yaml up -d

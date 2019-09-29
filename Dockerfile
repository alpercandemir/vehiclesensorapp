FROM java:8-jdk-alpine

COPY ./target/vehiclesensor-0.0.1-SNAPSHOT.jar /tmp

WORKDIR /tmp

RUN sh -c 'touch vehiclesensor-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","vehiclesensor-0.0.1-SNAPSHOT.jar"]  
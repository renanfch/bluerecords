FROM openjdk:8-jdk-alpine
RUN mkdir data
VOLUME data
COPY build/bluerecords.jar bluerecords.jar

ENV DATABASE_URL jdbc:h2:nio:./data/bluerecords_db;MODE=MySQL
ENV DATABASE_USER root
ENV DATABASE_PASSWORD 123456
ENV RABBITMQ_HOST rabbitmq
ENV RABBITMQ_USER rabbitmqUser
ENV RABBITMQ_PASSWORD rabbitmqPass
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=prod", "-jar", "/bluerecords.jar"]
FROM openjdk:16

LABEL maintainer="david.wood@tutanota.com"
COPY target/scorecard-api-0.0.1-SNAPSHOT.jar /scorecard-api.jar
EXPOSE 8081

CMD [ "java", "-jar", "scorecard-api.jar"]
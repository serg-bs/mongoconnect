FROM openjdk:17-alpine3.14

COPY target/demo-0.0.1-SNAPSHOT.jar ./
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]
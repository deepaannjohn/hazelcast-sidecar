
FROM openjdk:11-jre-slim
COPY target/hazelcast-sidecar-springboot-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

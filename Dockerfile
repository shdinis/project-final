FROM eclipse-temurin:17-jdk-alpine
VOLUME /jirarush
COPY target/jira*.jar app.jar
COPY resources resources

ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/app.jar"]

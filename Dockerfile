FROM adoptopenjdk:11 As builder
COPY gradlew /
COPY gradle gradle
COPY build.gradle.kts /
COPY settings.gradle.kts /
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew bootJar --no-daemon

FROM adoptopenjdk:11
COPY --from=builder build/libs/*.jar app.jar
EXPOSE 3001
ENTRYPOINT ["java", "-jar", "/app.jar"]
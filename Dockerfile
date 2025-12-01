FROM eclipse-temurin:21-jre

RUN adduser --system spring && mkdir /app && chown spring /app

USER spring
WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

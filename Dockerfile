FROM eclipse-temurin:17-jdk

WORKDIR /app
mvn clean package
java -jar target/ecommerce-app-1.0.jar
COPY target/ecommerce-app-1.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

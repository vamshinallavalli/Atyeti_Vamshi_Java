# Step 1: Use JDK for building
FROM eclipse-temurin:17-jdk-jammy AS builder
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Step 2: Runtime image
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

# Expose app port
EXPOSE 4041

# Run app
ENTRYPOINT ["java", "-jar", "app.jar"]
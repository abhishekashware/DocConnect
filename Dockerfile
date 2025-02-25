#
# Build stage
#
FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:17
COPY --from=build /target/doc-connect.jar doc-connect.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","doc-connect.jar"]
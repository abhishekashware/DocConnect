FROM openjdk:17
EXPOSE 8080
RUN mvn clean package -DskipTests
ADD target/doc-connect.jar doc-connect.jar
ENTRYPOINT ["java","-jar","/doc-connect.jar"]
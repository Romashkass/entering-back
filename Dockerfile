#
# BUILD STAGE
#
FROM maven:3.9.6-amazoncorretto-21-debian AS build
COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app  
RUN mvn -f /usr/src/app/pom.xml clean package

#
# PACKAGE STAGE
#
FROM openjdk:24-ea-21-jdk-slim
COPY --from=build /usr/src/app/target/entering-back-0.0.1.jar /usr/app/entering-back-0.0.1.jar
EXPOSE 8080  
CMD ["java","-jar","/usr/app/entering-back-0.0.1.jar"]
FROM openjdk:8-jdk-alpine
WORKDIR /home
COPY target/customer1-jar-with-dependencies.jar customer1-jar-with-dependencies.jar
EXPOSE 3331
CMD ["java", "-jar", "customer1-jar-with-dependencies.jar"]
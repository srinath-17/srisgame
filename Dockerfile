FROM openjdk:11.0.10-jre
WORKDIR /app
useradd srinath
COPY --from=build /app/target/shoes-0.0.1-SNAPSHOT.jar /app
EXPOSE 1002
CMD ["java","-jar","srigame-0.0.1-SNAPSHOT.jar"]

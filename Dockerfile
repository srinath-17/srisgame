FROM openjdk:11.0.10-jre
WORKDIR /app
ADDUSER -D -g srinath
COPY --from=build /app/target/srigame-0.0.1-SNAPSHOT.jar /app
EXPOSE 1002
CMD ["java","-jar","srigame-0.0.1-SNAPSHOT.jar"]

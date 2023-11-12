# Use an official OpenJDK runtime as a parent image
FROM openjdk:11

# Set the working directory in the container
WORKDIR /app

# Clone your Spring Boot project from GitHub
RUN apt-get update && apt-get install -y git
RUN git clone https://github.com/ZiemanJoao/MyPokemons.git .

# Build your Spring Boot application with Maven
RUN apt-get update && apt-get install -y maven
RUN mvn install
RUN mvn package

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "target/MyPokemon-0.0.1-SNAPSHOT.jar"]

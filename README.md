# Kafka Messaging Service

This project is a Spring Boot application that demonstrates how to send messages to a Kafka topic using REST endpoints. It includes functionality to add custom headers to Kafka messages and ensures proper file handling for unique message IDs.

## Features

- **REST API**: Exposes endpoints to send messages to Kafka.
- **Kafka Integration**: Uses Spring Kafka to produce messages to a Kafka topic.
- **Custom Headers**: Adds an `id` header to each Kafka message.
- **File Handling**: Prevents overwriting files by appending unique identifiers.

## Technologies Used

 - **Java**: Programming language.
 - **Spring Boot**: Framework for building the application.
 - **Apache Kafka**: Messaging system.
 - **Gradle**: Build tool.

## Configuration

Update the Kafka configuration in `src/main/resources/application.yml`:

```yaml
spring:
  kafka:
    bootstrap-servers: localhost:9092
    key-serializer: org.apache.kafka.common.serialization.StringSerializer
    value-serializer: org.apache.kafka.common.serialization.StringSerializer 
    


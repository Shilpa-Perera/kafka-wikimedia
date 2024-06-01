# Simple Producer-Consumer Application Using Apache Kafka, Spring Boot and MongoDB

This is a simple producer-consumer application built with Apache Kafka, MongoDB, and Spring Boot. The application demonstrates how to produce messages to a Kafka topic and consume them, subsequently storing the consumed messages in a MongoDB collection.

## Prerequisites
Before you begin, ensure you have met the following requirements:
- Java 11 or higher
- Apache Kafka
- MongoDB

## Architecture
The application consists of the following spring boot micro-services:
- **Producer**: ```producer-wikimedia``` retrieves wikimedia data from the stream API annd sends messages to a Kafka topic.
- **Consumer**: ```consumer-wikimedia``` listens to messages from the Kafka topic and saves them to MongoDB.
  
## Setup

### 1. Clone the repository
First, clone the repository and navigate to the project directory.
```bash
git clone https://github.com/your-username/producer-consumer-app.git
cd kafka-wikimedia
```
Open the cloned repository with IntelliJ IDEA or your preferred IDE.

### 2. Start the ZooKeeper service
Download the latest Kafka release and extract it. Navigate to the Kafka directory in your terminal and start the ZooKeeper service with the following command.
```bash
bin/zookeeper-server-start.sh config/zookeeper.properties
```
For Windows, 

```bash
bin\windows\zookeeper-server-start.bat config\zookeeper.properties
```
### 3. Start the Kafka broker service
In a new terminal window (still in the Kafka directory), start the Kafka broker service.
```bash
bin/kafka-server-start.sh config/server.properties
```
For Windows,
```bash
bin\kafka-server-start.bat config\server.properties
```
### 4. Setup a MongoDB database
Ensure MongoDB is running. If using MongoDB Compass, connect to localhost:27017 and create a database named wikimedia.

### 5. Configure Spring Boot Applications
Ensure the application.properties files in both the producer and consumer services are correctly configured with your Kafka and MongoDB settings.

Producer Configuration (producer-wikimedia/src/main/resources/application.properties)
```bash
spring.kafka.producer.bootstrap-servers:localhost:9092
spring.kafka.producer.key-serializer: org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer: org.apache.kafka.common.serialization.StringSerializer
```
Consumer Configuration (consumer-wikimedia/src/main/resources/application.properties)
```bash
spring.kafka.consumer.bootstrap-servers: localhost:9092
spring.kafka.consumer.group-id: learnGrp
spring.kafka.consumer.auto-offset-reset: earliest
spring.kafka.consumer.key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer: org.apache.kafka.common.serialization.StringDeserializer


spring.data.mongodb.host: localhost
spring.data.mongodb.port: 27017
spring.data.mongodb.database: wikimedia
spring.data.mongodb.repositories.enabled: true
```

### 6. Run the application
Run both the Producer and Consumer Spring Boot applications. You can do this from your IDE. 

### 7. Verify the Setup
You should see messages being produced to the Kafka topic and consumed by the consumer service. The consumed messages will be saved to the wikimedia database in MongoDB.



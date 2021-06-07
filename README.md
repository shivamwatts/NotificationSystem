# NotificationSystem
This is the code repository for notification application using Sprin Kafka.

### This application will allow you to perform following operations
* send the message to Kafka topic.
* Consume the messages from Kafka topic
* Push the notifications to multiple channels such as email, slack, ...

### Setting up Kakfa
1. Download Kafka
2. Configure Zookeeper.properties and Server.properties file
   * Create kafka-logs and zookeeper log folder in your Kafka directory.
   * Go to your Kafka config directory. For me its C:\kafka_2.11-0.9.0.0\config
   * Edit the file “server.properties.”
   * Find and edit the line log.dirs=/tmp/kafka-logs” to “log.dir= C:\kafka_2.11-0.9.0.0\kafka-logs.
   * Edit the “zookeeper.properties.”
   * Find and edit the line log.dirs=/tmp/kafka-logs” to “log.dir= C:\kafka_2.11-0.9.0.0\zookeeper-logs.
3. Run Zookeeper
   * .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

4. Run Kafka Server
   * .\bin\windows\kafka-server-start.bat .\config\server.properties
5. Create Topics(emailMessages, slackMessages). Run this command inside windows folder of Kafka directory.
   * kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic "TOPIC_NAME"

### Runing the application on STS IDE
---
1. Clone the repo
2. Import as Spring boot project
3. run the project as Spring Boot App

### Send the Notification to Kafka Topic
---
Import the following curl snippet in your post man
* API to send the data to Kafka Topic : http://localhost:8080/send/channelType/{channelType}
```
curl --location --request POST 'localhost:8080/send/channelType/slack' \
--header 'Content-Type: application/json' \
--data-raw '{
    "from":"shivam.watts@gmail.com",
    "to":"rohan.mehra@gmail.com",
    "subject":"Meeting Regarding Kafka",
    "body":"Hello, let'\''s meet."
}'
```

### Console Output
---
View the result in console
* Kafka consumer will consume the message from the topics and will print on console
Sample output
```
Received slack Notification: Message{subject='Meeting Regarding Kafka', from='shivam.watts@gmail.com', to='rohan.mehra@gmail.com', body='Hello, let's meet.'}

```

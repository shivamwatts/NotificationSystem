package com.example.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	/**
	 * Consumer to read all the messages
	 * 
	 * @param message
	 */
	@KafkaListener(topics = { "${kafka.email.topic.name}",
			"${kafka.slack.topic.name}" }, groupId = "${kafka.consumer.groupId}")
	public void consume(ConsumerRecord<?, ?> record) {
		System.out.println("Received " + record.key().toString() + " Notification: " + record.value().toString());
	}

}

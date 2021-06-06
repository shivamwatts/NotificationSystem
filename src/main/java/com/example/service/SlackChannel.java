package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.example.model.Message;
import com.example.utils.Constants;

@Component
public class SlackChannel implements Channel {

	@Value(value = "${kafka.slack.topic.name}")
	private String topicName;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	/**
	 * Send the slack data to slack specific topic
	 */
	@Override
	public void sendToKafkaTopic(Message message) {
		kafkaTemplate.send(topicName, Constants.SLACK_CHANNEL, message.toString());
	}
}

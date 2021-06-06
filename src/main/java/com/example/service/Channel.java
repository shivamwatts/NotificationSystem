package com.example.service;

import com.example.model.Message;

public interface Channel {

	public void sendToKafkaTopic(Message message);
}

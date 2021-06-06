package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Message;
import com.example.model.Response;

@Service
public class ChannelService {

	@Autowired
	ChannelFactory factory;

	public Response send(Message message, String messageType) {
		Channel channel = factory.getChannelType(messageType);
		if (channel != null) {
			channel.sendToKafkaTopic(message);
			return Response.SUCESS;
		}
		else {
			return Response.ERROR;
		}
	}

}

package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Message;
import com.example.model.Response;
import com.example.service.ChannelService;
import com.example.utils.Constants;

/**
 * 
 * @author swatts
 *
 */
@RestController
public class NotificationSystemController {

	@Autowired
	ChannelService service;

	@PostMapping("/send/channelType/{channelType}")
	public String sendMessage(@PathVariable String channelType, @RequestBody Message message) {
		Response response = service.send(message, channelType);
		if (response == Response.SUCESS) {
			return response.toString();
		} else {
			return response.toString() + Constants.CHANNEL_NOT_SUPPORTED;
		}
	}

}

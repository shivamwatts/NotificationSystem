package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.utils.Constants;

/**
 *Factory class to get the channel object
 * 
 * @author swatts
 *
 */
@Component
public class ChannelFactory {
	
	@Autowired
	EmailChannel email;
	
	@Autowired
	SlackChannel slack;

	/**
	 * To get the channel according to the type
	 * 
	 * @param messageType
	 * @return
	 */
	public Channel getChannelType(String messageType) {
		if (messageType.equals(Constants.EMAIL_CHANNEL)) {
			return email;
		} else if (messageType.equals(Constants.SLACK_CHANNEL)) {
			return slack;
		} else {
			return null;
		}
	}
}

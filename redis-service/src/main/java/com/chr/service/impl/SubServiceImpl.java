/**
 * 2014-7-2 
 * SubServiceImpl.java 
 * author:Edwin Chen
 */
package com.chr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import com.chr.domain.MessageList;
import com.chr.service.SubService;

/**
 * @author new
 * 
 */

public class SubServiceImpl implements SubService {
	@Autowired
	private ChannelTopic channelTopic;

	private MessageList messageList = new MessageList();

	public void onMessage(Message message, byte[] pattern) {
		System.out.println(message.toString() + "  " + channelTopic.getTopic());
		messageList.add(message.toString());
	}

	public MessageList getMessageList() {
		return messageList;
	}
}

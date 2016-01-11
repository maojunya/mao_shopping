/**
 * 2014-7-2 
 * PubSubServiceImpl.java 
 * author:Edwin Chen
 */
package com.chr.service.impl;



import javax.annotation.Resource;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.chr.service.PubService;

/**
 * @author new
 *
 */

@Service
public class PubServiceImpl implements PubService {
	@Resource(name="stringRedisTemplate")
	private  StringRedisTemplate stringRedisTemplate;
	
	private String channelTopic = "user:topic";
	
	/*发布消息到Channel*/
	public void Publisher(String message) {
		stringRedisTemplate.convertAndSend(channelTopic, message);
	}
}

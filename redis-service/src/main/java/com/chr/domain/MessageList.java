/**
 * 2014-7-2 
 * Message.java 
 * author:Edwin Chen
 */
package com.chr.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author new
 * 
 */
public class MessageList {
	private static List<String> messageList = new ArrayList<String>();

	public void add(String message) {
		messageList.add(message);
	}
	
	public List<String> output() {
		Iterator<String> it = messageList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		return messageList;
	}
}

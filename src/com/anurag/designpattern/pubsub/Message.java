package com.anurag.designpattern.pubsub;

public class Message {
	final String messageContent;

	public Message(String msg) {
		this.messageContent = msg;
	}

	public String getMessageContent() {
		return messageContent;
	}
}

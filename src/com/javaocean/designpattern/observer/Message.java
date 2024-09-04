package com.javaocean.designpattern.observer;

public class Message {
	final String messageContent;

	public Message(String msg) {
		this.messageContent = msg;
	}

	public String getMessageContent() {
		return messageContent;
	}
}

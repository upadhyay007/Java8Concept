package com.javaocean.designpattern.observer;

public class MessageObserver1 implements Oberver {
	@Override
	public void update(Message message) {
		System.out.println("MessageObserver 1 : " + message.getMessageContent());
	}
}

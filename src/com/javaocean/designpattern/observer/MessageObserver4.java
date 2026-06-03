package com.javaocean.designpattern.observer;

public class MessageObserver4 implements Oberver {
	@Override
	public void update(Message message) {
		System.out.println("MessageObserver 4 : " + message.getMessageContent());
	}
}

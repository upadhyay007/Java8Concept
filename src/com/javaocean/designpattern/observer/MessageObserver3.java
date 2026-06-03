package com.javaocean.designpattern.observer;

public class MessageObserver3 implements Oberver {
	@Override
	public void update(Message message) {
		System.out.println("MessageObserver 3 : " + message.getMessageContent());

	}

}

package com.javaocean.designpattern.observer;

public class MessageObserver5 implements Oberver {
	@Override
	public void update(Message message) {
		System.out.println("MessageObserver 5 : " + message.getMessageContent());

	}

}

package com.anurag.designpattern.pubsub.copy;

public class MessageObserver2 implements Oberver {
	@Override
	public void update(Message message) {
		System.out.println("MessageObserver 2 : " + message.getMessageContent());

	}

}

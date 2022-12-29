package com.anurag.designpattern.pubsub;

public class MessageObserver1 implements Oberver {
	@Override
	public void update(Message message) {
		System.out.println("MessageObserver 1 : " + message.getMessageContent());
	}
}

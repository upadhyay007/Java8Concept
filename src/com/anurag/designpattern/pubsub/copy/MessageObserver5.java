package com.anurag.designpattern.pubsub.copy;

public class MessageObserver5 implements Oberver {
	@Override
	public void update(Message message) {
		System.out.println("MessageObserver 5 : " + message.getMessageContent());

	}

}

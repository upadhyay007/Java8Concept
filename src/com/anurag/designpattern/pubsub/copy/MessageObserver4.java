package com.anurag.designpattern.pubsub.copy;

public class MessageObserver4 implements Oberver {
	@Override
	public void update(Message message) {
		System.out.println("MessageObserver 4 : " + message.getMessageContent());

	}

}

package com.anurag.designpattern.pubsub.copy;
//under this concept from how to do in java.com
public class TestObserver {
	public static void main(String[] args) {

		MessagePublisher publisher = new MessagePublisher();
		
//		publisher.suscribe(new MessageObserver4());
//		publisher.suscribe(new MessageObserver2());
//		publisher.suscribe(new MessageObserver1());
//		publisher.suscribe(new MessageObserver5());
//
//		publisher.notifyUpdate(new Message("Hello Observer"));
//
//		publisher.suscribe(new MessageObserver3());
//		publisher.notifyUpdate(new Message("My State Updated !!"));
		
		MessageObserver1 messageObserver1 = new MessageObserver1();
		MessageObserver2 messageObserver2 = new MessageObserver2();
		MessageObserver3 messageObserver3 = new MessageObserver3();
		MessageObserver4 messageObserver4 = new MessageObserver4();
		MessageObserver5 messageObserver5 = new MessageObserver5();
		
		Message message = new Message("Observer");
		
		publisher.subscribe(messageObserver1);
		publisher.subscribe(messageObserver2);
		publisher.subscribe(messageObserver3);
		publisher.subscribe(messageObserver4);

		publisher.notifyUpdate(new Message("Hello Observer"));

		publisher.subscribe(messageObserver5);   // Subscribe 
		publisher.unSubscribe(messageObserver2); // unSuscribe
		publisher.unSubscribe(messageObserver1); // unSuscribe
		publisher.notifyUpdate(new Message("My State Updated !!"));

	}
}

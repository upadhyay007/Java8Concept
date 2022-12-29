package com.anurag.designpattern.pubsub.copy;

public interface Subject {
	void subscribe(Oberver oberver);

	void unSubscribe(Oberver oberver);

	void notifyUpdate(Message message);
}

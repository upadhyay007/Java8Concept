package com.javaocean.designpattern.observer;

public interface Subject {
	void subscribe(Oberver oberver);

	void unSubscribe(Oberver oberver);

	void notifyUpdate(Message message);
}

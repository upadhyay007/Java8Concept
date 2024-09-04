package com.javaocean.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class MessagePublisher implements Subject {
	
	private List<Oberver> observers = new ArrayList<>();
	
	@Override
	public void subscribe(Oberver oberver) {
		observers.add(oberver);
	}

	@Override
	public void unSubscribe(Oberver oberver) {
		observers.remove(oberver);
	}

	@Override
	public void notifyUpdate(Message message) {
		for (Oberver oberver : observers) {
			oberver.update(message);
		}

	}

}

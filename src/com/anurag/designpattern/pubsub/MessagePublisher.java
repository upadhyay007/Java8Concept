package com.anurag.designpattern.pubsub;

import java.util.ArrayList;
import java.util.List;

public class MessagePublisher implements Subject {
	
	private List<Oberver> observers = new ArrayList<>();
	
	@Override
	public void suscribe(Oberver oberver) {
		observers.add(oberver);
	}

	@Override
	public void unsuscribe(Oberver oberver) {
		observers.remove(oberver);
	}

	@Override
	public void notify(Message message) {
		// TODO Auto-generated method stub

	}

}

package com.anurag.designpattern.pubsub;

public interface Subject {
 void suscribe(Oberver oberver);
 void unsuscribe(Oberver oberver);
 void notify(Message message);
}

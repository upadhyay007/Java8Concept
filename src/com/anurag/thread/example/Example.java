package com.anurag.thread.example;

import java.util.LinkedList;
import java.util.Queue;

public class Example {
	public static void main(String[] args) {
		
		Queue<Integer> integers = new LinkedList<>();
		
		Thread producer = new Thread(new ProducerExample(integers));
		Thread consumer = new Thread( new ConsumerExample(integers));
		
		producer.start();
		consumer.start();		

	}
}

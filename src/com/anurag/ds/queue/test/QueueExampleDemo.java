package com.anurag.ds.queue.test;

public class QueueExampleDemo {
public static void main(String[] args) {
	QueueExample example = new QueueExample();
	System.out.println("IS Example"+ example.isEmpty());
	
	example.add(1);
	example.add(11);
	example.add(12);
	example.add(14);
	example.add(21);
	example.add(16);
	example.add(17);
	example.add(18);
	example.add(19);
	System.out.println("IS Example"+ example.isEmpty());
	System.out.println("Size : "+ example.size);
	
	
	
	example.view();
	System.out.println("IS Example"+ example.isEmpty());
	System.out.println("Size : "+ example.size);
	
}
}

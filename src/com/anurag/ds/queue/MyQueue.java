package com.anurag.ds.queue;

public class MyQueue {
	private Node font;
	private Node rear;
	private int size;

	public MyQueue() {
		this.font = null;
		this.rear = null;
		this.size = 0;
	}

	public int length() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int first() {
		if (isEmpty()) {
			System.out.println("Queue is empty!!");
		}
		return font.value;
	}

	public int last() {
		if (isEmpty()) {
			System.out.println("Queue is empty!!");
		}
		return rear.value;
	}

	public void add(int value) {

		Node newValue = new Node(value);

		if (isEmpty()) {
			font = newValue;
		} else {
			rear.next = newValue;
		}
		rear = newValue;
		size++;

	}

	public int deQueue() {
		if (isEmpty()) {

		}
		int value = font.value;
		this.font = font.next;

		if (font == null) {
			rear = null;
		}
		size--;
		return value;
	}

	public void view() {
		if (isEmpty()) {
			System.out.println("Empty Queue!!");
		}
		Node frontNode = font;
		while (frontNode != null) {
			System.out.println(frontNode.value);
			frontNode = frontNode.next;

		}
		System.out.println("Null");
	}
}

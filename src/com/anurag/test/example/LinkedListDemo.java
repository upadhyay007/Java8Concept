package com.anurag.test.example;

class Node {
	int value;
	Node next;

	public Node(int value) {
		this.value = value;
	}
}

class LinkedList {
	private Node head;

	public LinkedList() {

	}

	public void insertATFirst(int value) {
		Node node = new Node(value);
		node.next = head;
		head = node;
	}

	public void insertATEnd(int value) {
		Node node = new Node(value);
		if (head == null) {
			node.next = head;
			head = node;
			return;
		}
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = node;
	}

	public void delete(int value) {
		if (head == null) {
			return;
		}
		if (head.value == value) {
			head = head.next;
		}
		Node current = head;
		while (current.next != null) {
			if (current.next.value == value) {
				current.next = current.next.next;
			}
		}
	}

	public void display() {
		while (head != null) {
			System.out.println(head.value);
			head = head.next;
		}
	}

}

public class LinkedListDemo {
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.insertATEnd(1);
		linkedList.insertATEnd(12);
		linkedList.insertATEnd(14);
		linkedList.insertATEnd(15);
		linkedList.insertATEnd(18);
		linkedList.display();
	}
}

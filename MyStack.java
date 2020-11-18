package myDataStructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyStack<E> implements Iterable<E> {
	static class Node<E> {
		E ele;
		Node<E> next;
		
		Node(E ele) {
			this.ele = ele;
		}
	}
	
	private class MyStackIterator implements Iterator<E> {
		private Node<E> current = head;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}
		
		@Override
		public E next() {
			if (!hasNext()) throw new NoSuchElementException();
			E ele = current.ele;
			current = current.next;
			return ele;
		}
	}
	
	private Node<E> head = null;
	
	public void push(E ele) {
		Node<E> node = new Node(ele);
	
		node.next = head;
		head = node;
	}
	
	public E pop() {
		if (head == null) return null;
		
		Node<E> prev = head;
		head = head.next;
		prev.next = null;
		return prev.ele;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new MyStackIterator();
	}
}

package myDataStructure;

import java.util.Iterator;

public class App {
	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<>();
		
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		
		stack.pop();
		
		Iterator<Integer> iter = stack.iterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}

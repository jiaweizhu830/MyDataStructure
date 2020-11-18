package myDataStructure;

import java.util.Arrays;


public class MyHashMap<K, V> {
	
}

//public class MyHashMap<K, V> {
//	public static class Node<K, V> {
//		final K key;
//		V value;
//		Node<K, V> next;
//		
//		public Node(K key, V value){
//			this.key = key;
//			this.value = value;
//		}
//		
//		public K getKey() {
//			return key;
//		}
//		
//		public V getValue() {
//			return value;
//		}
//		
//		public void setValue(V value) {
//			this.value = value;
//		}
//	}
//	
//	//load factor 
//	
//	
//	private Node<K, V>[] array;
//	private int size; //#of actual map entries
//	
//	static final float DEFAULT_LOAD_FACTOR = 0.75f;
//	static final int DEFAULT_CAPACITY = 16;
//	
//	private final float loadFactor;
//	private final int cap;
//	
//	public MyHashMap() {
//		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
//	}
//	
//	public MyHashMap(int cap, float loadFactor) {
//		if (cap <= 0) {
//			throw new IllegalArgumentException("cap cannot be <= 0");
//		}
//		
//		this.cap = cap;
//		this.loadFactor = loadFactor;
//	}
//	
//	public V get(K key) {
//		//get the bucket id (index for the array)
//		
//		//iterate over the LL if contains key => return that key's value
//		int index = getIndex(key);
//		
//		Node<K, V> head = array[index];
//		
//		while (head != null) {
//			if (equalsKey(head.key, key)) return head.value;
//			head = head.next;
//		}
//		
//		return null;
//		
//	}
//	
//	//append new entry at the head of the LL
//	public V put(K key, V value) {
//		int index = getIndex(key);
//		
//		Node<K, V> head = array[index];
//		Node<K, V> node = head;
//		
//		while (node != null) {
//			if (equalsKey(node.key, key)) {
//				V preValue = node.value;
//				node.value = value;
//				return preValue;
//			}
//			node = node.next;
//		}
//		
//		Node<K, V> newNode = new Node(key, value);
//		newNode.next = head;
//		array[index] = newNode;
//		size++;
//		
//		if (needRehash()) {
//			rehash();
//		}
//		
//		return null;
//	}
//	
//	//remove
//	public V remove(K key) {
//		int index = getIndex(key);
//		Node<K, V> head = array[index];
//		
//		Node<K, V> dummy = new Node(-1, -1);
//		dummy.next = head;
//		Node<K, V> prev = dummy;
//		
//		while (head != null) {
//			if (equalsKey(head.key, key)) {
//				prev.next = head.next;
//				head.next = null;
//				
//				array[index] = dummy.next;
//				size--;
//				
//				return head.value;
//			}
//			
//			prev = prev.next;
//			head = head.next;
//		}
//		
//		return null;
//	}
//	
//	private boolean equalsKey(K key1, K key2) {
//		return key1 == key2 || key1 != null && key1.equals(key2);
//	}
//	
//	public boolean containsKey(K key) {
//		int index = getIndex(key);
//		
//		Node<K, V> head = array[index];
//		
//		while (head != null) {
//			if (equalsKey(head.key, key)) {
//				return true;
//			}
//			head = head.next;
//		}
//		return false;
//	}
//	
//	public boolean equalsValue(V value1, V value2) {
//		return value1 == value2 || value1 != null && value1.equals(value2);
//	}
//	
//	public boolean containsValue(V value) {
//		
//		//search all LL
//		for (Node<K, V> head: array) {
//			while (head != null) {
//				if (equalsValue(head.value, value)) return true;
//				head = head.next;
//			}
//		}
//		
//		return false;
//	}
//	
//	public int size() {
//		return size;
//	}
//	
//	public boolean isEmpty() {
//		return size == 0;
//	}
//	
//	public void clear() {
//		Arrays.fill(array, null);
//		size = 0;
//	}
//	
//	private boolean needRehash() {
//		float ratio = (size + 0.0f) / array.length;
//		return ratio >= loadFactor;
//	}
//	
//	private void rehash() {
//		//double the array length
//		//re put each node => new array
//		Node<K, V>[] oldArray = array;
//		array = (Node<K, V>[]) (new Node[array.length * 2]);
//		
//		for (Node<K, V> head: oldArray) {
//			while (head != null) {
//				put(head.key, head.value);
//				head = head.next;
//			}
//		}
//	}
//	
//	private int getIndex(K key) {
//		return hash(key) % array.length;
//	}
//	
//	private int hash(K key) {
//		if (key == null) return 0;
//		
//		//011111111111's
//		return key.hashCode() & 0X7FFFFFF;
//	}	
//}

//public class MyHashMap<K, V> {
//	// Node is a static class of MyHashMap
//		//bc it is very closely bonded to MyHashMap class
//		//and we probably need to access this class outside from MyHashMap class
//	public static class Node<K, V> {
//		final K key;
//		V value;
//		Node<K, V> next;
//		
//		Node(K key, V value) {
//			this.key = key;
//			this.value = value;
//		}
//		
//		public K getKey() {
//			return key;
//		}
//		
//		public V getValue() {
//			return value;
//		}
//		
//		public void setValue(V value) {
//			this.value = value;
//		}
//	}
//	
//	//static final: global constants
//	public static final int DEFAULT_CAPACITY = 16;
//	public static final float DEFAULT_LOAD_FACTOR = 0.75f;
//	
//	private Node<K, V>[] array;
//	// how many key-value pairs are actually stored in the HashMap
//	private int size;
//	// determine when to rehash
//	private float loadFactor;
//	
//	public MyHashMap() {
//		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
//	}
//	
//	public MyHashMap(int cap, float loadFactor) {
//		if (cap <= 0) {
//			throw new IllegalArgumentException("cap cannot be <= 0");
//		}
//		
//		//no generic arrays in Java
//		this.array = (Node<K, V>[]) (new Node[cap]);
//		this.size = 0;
//		this.loadFactor = loadFactor;
//	}
//	
//	public int size() {
//		return size;
//	}
//	
//	public boolean isEmpty() {
//		return size == 0;
//	}
//	
//	public void clear() {
//		Arrays.fill(this.array, null);
//		size = 0;
//	}
//	
//	private int hash(K key) {
//		//1. null key
//		if (key == null) {
//			return 0;
//		}
//		
//		//2. hashCode
//		//int code = key.hashCode()
//		//return code >= 0 ? code : -code; (取绝对值)
//		//int range [-2^31, 2^31-1]
//		//but the problem: -Integer.MIN_VALUE = Integer.MIN_VALUE => overflow
//		
//		//0x: hexadecimal 
//		//7: 0111
//		//F: 1111
//		//get absolute value => guarantee non-negative
//		return key.hashCode() & 0X7FFFFFFF;
//	}
//	
//	private int getIndex(K key) {
//		return hash(key) % array.length;
//	}
//	
//	private boolean equalsValue(V v1, V v2) {
//		return v1 == v2 || v1 != null && v1.equals(v2);
//	}
//	
//	//O(n) traverse the whole array, 
//	//and traverse the whole linked list in the array
//	public boolean containsValue(V value) {
//		if (isEmpty()) {
//			return false;
//		}
//		
//		for (Node<K, V> node: array) {
//			while (node != null) {
//				if (equalsValue(node.value, value)) {
//					return true;
//				}
//				
//				node = node.next;
//			}
//		}
//		
//		return false;
//	}
//	
//	//key, node.key() both possible to be null
//	public boolean equalsKey(K k1, K k2) {
//		return k1 == k2 || k1 != null && k1.equals(k2);
//	}
//	
//	public boolean containsKey(K key) {
//		int index = getIndex(key);
//		Node<K, V> node = array[index];
//		
//		while(node != null) {
//			if (equalsKey(node.key, key)) {
//				return true;
//			}
//			
//			node = node.next;
//		}
//		
//		return false;
//	}
//	
//	//if key NOT exist in the HashMap => return null
//	public V get(K key) {
//		int index = getIndex(key);
//		Node<K, V> node = array[index];
//		
//		while (node != null) {
//			if (equalsKey(node.key, key)) {
//				return node.value;
//			}
//			
//			node = node.next;
//		}
//		
//		return null;
//	}
//	
//	//insert/update
//	//if the key already exists => return the prev value
//	//if the key NOT exist => return null
//	public V put(K key, V value) {
//		int index = getIndex(key);
//		Node<K, V> head = array[index];
//		Node<K, V> node = head;
//		
//		while (node != null) {
//			if (equalsKey(node.key, key)) {
//				V result = node.value;
//				node.value = value;
//				return result;
//			}
//			
//			node = node.next;
//		}
//		
//		//insert
//		//append the new node before the head
//		Node<K, V> newNode = new Node(key, value);
//		newNode.next = head;
//		array[index] = newNode;
//		size++;
//		
//		if (needRehashing()) {
//			rehashing();
//		}
//		
//		return null;
//	}
//	
//	private boolean needRehashing() {
//		float ratio = (size + 0.0f) / array.length;
//		return ratio >= loadFactor;
//	}
//	
//	private void rehashing() {
//		//new double sized array
//		//for each node in the old array
//		//do put() to the new larger array
//		Node<K, V>[] oldArray = array;
//		array = (Node<K, V>[]) (new Node[2 * array.length]);
//		
//		for (Node<K, V> node: oldArray) {
//			while (node != null) {
//				put(node.key, node.value);
//				node = node.next;
//			}
// 		}
//			
//	}
//
//	// if key exists => remove <key, value> from HashMap, return value 
//	// if key NOT exists => return null
//	public V remove(K key) {
//		int index = getIndex(key);
//		Node<K, V> head = array[index];
//		
//		Node<K, V> dummy = new Node(-1, -1);
//		dummy.next = head;
//		Node<K, V> prev = dummy;
//		
//		while (head != null) {
//			if (equalsKey(head.key, key)) {
//				prev.next = head.next;
//				head.next = null;
//				size--;
//				array[index] = dummy.next;
//				return head.value;
//			}
//			
//			prev = prev.next;
//			head = head.next;
//		}
//		
//		
//		return null;
//	}
//}

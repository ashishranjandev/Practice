package org.home.prac.ds.hash;

public class BasicHashTable<K, V> {
	
	private HashEntry[] data;
	private int capacity;
	private int size;
	
	public BasicHashTable(int tableSize) {
		this.capacity = tableSize;
		this.data = new HashEntry[this.capacity];
	}
	
	public V get(K key) {
		int hash = calculateHash(key);
		
		if(data[hash] == null) {
			return null;
		} else {
			return (V) data[hash].getValue();
		}
	}
	
	public void put(K key, V value) {
		int hash = calculateHash(key);
		
		data[hash] = new HashEntry(key, value);
		size++;
	}
	
	private int calculateHash(K key) {
		int hash = (key.hashCode() % this.capacity);
		// for collision scenarios
		while(data[hash] != null && !data[hash].getKey().equals(key)) {
			hash = (hash + 1) % this.capacity;
		}
		return hash;
	}
	
	public int size() {
		return this.size;
	}
	
	private class HashEntry<K, V> {
		private K key;
		private V value;
		
		public HashEntry(K key, V value) {
			super();
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}
		
	}
}

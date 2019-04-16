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
	
	public V delete(K key) {
		V value = get(key);
		
		//clear out hashtable slot for the key and return the removed value
		if(value != null) {
			int hash = calculateHash(key);
			data[hash] = null;
			size --;
			hash = (hash + 1) % this.capacity;
			
			//If  the next slot isn't empty we should re add it so we can keep hash algorithms clean
			while(data[hash] != null) {
				HashEntry entry = data[hash];
				data[hash] = null;
				put((K)entry.getKey(), (V)entry.getValue());
				// we positioned the hash items and didn't really add a new one so back off the size
				size --;
				hash = (hash + 1) % this.capacity;
			}
		}
		return value;
	}
	
	public boolean containsKey(K key) {
		int hash = calculateHash(key);
		
		//if we don't have anything for the given key, we can return false
		if(data[hash] == null) {
			return false;
		}
		// otherwise get the hashentry for the key and see if it matches the key
		else {
			if(data[hash].getKey().equals(key)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsValue(V value) {
		// loop through all hash entries
		for(int i = 0; i < this.capacity; i++) {
			HashEntry entry = data[i];
			
			//Check if hashentry is not null and the hashentry has the value
			if(entry != null && entry.getValue().equals(value)) {
				return true;
			}
		}
		return false;
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
